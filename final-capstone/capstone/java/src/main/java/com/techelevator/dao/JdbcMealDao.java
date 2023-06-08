package com.techelevator.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Food;
import com.techelevator.model.Meal;
import com.techelevator.model.MealDto;
import org.springframework.dao.*;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealDao implements MealDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public int addMeal(Meal meal, int userId) {
        Integer newMealId = 0;
        Integer foodId = 0;

        // add meal to the database AND grab meal id
        String sql = "INSERT INTO meal_history(user_id, meal_date, type, total_calories) " +
                "VALUES(?,NOW()::date,?,?) RETURNING meal_history_id;";
        try {
            newMealId = jdbcTemplate.queryForObject(sql, Integer.class, userId, meal.getType(), meal.getTotalCalories());
        } catch (DataAccessException e) {
            if (e instanceof CannotGetJdbcConnectionException) {
                System.out.println("Cannot get JDBC connection: " + e.getMessage());
            } else if (e instanceof DataIntegrityViolationException) {
                System.out.println("Data integrity violation: " + e.getMessage());
            } else if (e instanceof DuplicateKeyException) {
                System.out.println("Duplicate key violation: " + e.getMessage());
            } else if (e instanceof IncorrectResultSizeDataAccessException) {
                System.out.println("Incorrect result size: " + e.getMessage());
            } else if (e instanceof InvalidDataAccessApiUsageException) {
                System.out.println("Invalid usage of JdbcTemplate: " + e.getMessage());
            } else {
                System.out.println("Data access exception occurred: " + e.getMessage());
            }
        }
        // call method to add foods to db, retrieve and return their ids
        List<Integer> foodIdList = new ArrayList<>();

        for(Food food : meal.getFoodList()) {
            foodId = addFood(food);

            if (!(foodId == -1)) {
                foodIdList.add(foodId);
            }
        }

        // add meal id and food ids to associative table
        updateJunctionTable(newMealId, foodIdList);

        return newMealId;
    }

    public Food getFoodById(int foodId) {
        Food food = null;
        String sql = "SELECT * FROM foods WHERE food_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, foodId);
        if(results.next()) {
            food = mapRowToFood(results);
        }
        return food;
    }

    @Override
    public List<Meal> getMealsByUserId(int userId) {
        List<Meal> mealList = new ArrayList<>();
        String sql = "SELECT * FROM meal_history WHERE user_id = ?" +
                    " ORDER BY meal_date, meal_history_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            mealList.add(mapRowToMeals(results));
        }
        return mealList;

    }

    public Integer addFood(Food food) {
        String sql = "INSERT INTO foods (food_name, calories, serving_size, number_of_servings)" +
                " VALUES (?,?,?,?) RETURNING food_id;";

        try {
            Integer newFoodId = jdbcTemplate.queryForObject(sql, Integer.class, food.getFoodName(), food.getCalories(),
                    food.getServingSize(), food.getNumberOfServings());
            return newFoodId;
        } catch (DataAccessException e) {
            if (e instanceof CannotGetJdbcConnectionException) {
                System.out.println("Cannot get JDBC connection: " + e.getMessage());
            } else if (e instanceof DataIntegrityViolationException) {
                System.out.println("Data integrity violation: " + e.getMessage());
            } else if (e instanceof DuplicateKeyException) {
                System.out.println("Duplicate key violation: " + e.getMessage());
            } else if (e instanceof IncorrectResultSizeDataAccessException) {
                System.out.println("Incorrect result size: " + e.getMessage());
            } else if (e instanceof InvalidDataAccessApiUsageException) {
                System.out.println("Invalid usage of JdbcTemplate: " + e.getMessage());
            } else {
                System.out.println("Data access exception occurred: " + e.getMessage());
            }
        }

        return -1;
    }

    public void updateJunctionTable(Integer mealId, List<Integer> foodIds) {
        String sql = "INSERT INTO meal_history_foods (meal_history_id, food_id)" +
                " VALUES (?, ?);";

        try {
            for(Integer foodId : foodIds) {
                jdbcTemplate.update(sql, mealId, foodId);
            }
        } catch (DataAccessException e) {
            if (e instanceof CannotGetJdbcConnectionException) {
                System.out.println("Cannot get JDBC connection: " + e.getMessage());
            } else if (e instanceof DataIntegrityViolationException) {
                System.out.println("Data integrity violation: " + e.getMessage());
            } else if (e instanceof DuplicateKeyException) {
                System.out.println("Duplicate key violation: " + e.getMessage());
            } else if (e instanceof IncorrectResultSizeDataAccessException) {
                System.out.println("Incorrect result size: " + e.getMessage());
            } else if (e instanceof InvalidDataAccessApiUsageException) {
                System.out.println("Invalid usage of JdbcTemplate: " + e.getMessage());
            } else {
                System.out.println("Data access exception occurred: " + e.getMessage());
            }
        }
    }

    public List<Integer> getFoodIdsByMealId(int mealId) {
        //List<Food> foodList = new ArrayList<>();
        List<Integer> foodIds = new ArrayList<>();
        String sql = "SELECT * FROM meal_history_foods WHERE meal_history_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mealId);
            while(results.next()) {
                foodIds.add(results.getInt("food_id"));
                //foodList.add(mapRowToFood(results));
            }
        } catch(Exception e) {
            System.out.println("Error in getFoodIdsByMealId method");
        }



        return foodIds;
    }

    public boolean updateMeal(MealDto meal, int userId) {
        String sql = "UPDATE meal_history" +
                " SET user_id = ?, meal_date = ?, type = ?, total_calories = ?" +
                " WHERE meal_history_id = ?";

        try {
            jdbcTemplate.update(sql, userId, meal.getMealDate(), meal.getMealType(),
                                meal.getTotalCalories(), meal.getMealId());
            return true;
        }
        catch (DataAccessException e) {
            System.err.println("Could not connect to database.");
        }

        return false;
    }

    public boolean deleteMeal(int mealId) {
        String junctionSql = "DELETE FROM meal_history_foods WHERE meal_history_id = ?";
        String deleteSql = "DELETE FROM meal_history WHERE meal_history_id = ?";

        try {
            jdbcTemplate.update(junctionSql, mealId);
            jdbcTemplate.update(deleteSql, mealId);
            return true;
        }
        catch (DataAccessException e) {
            if (e instanceof CannotGetJdbcConnectionException) {
                System.out.println("Cannot get JDBC connection: " + e.getMessage());
            } else if (e instanceof DataIntegrityViolationException) {
                System.out.println("Data integrity violation: " + e.getMessage());
            } else if (e instanceof DuplicateKeyException) {
                System.out.println("Duplicate key violation: " + e.getMessage());
            } else if (e instanceof IncorrectResultSizeDataAccessException) {
                System.out.println("Incorrect result size: " + e.getMessage());
            } else if (e instanceof InvalidDataAccessApiUsageException) {
                System.out.println("Invalid usage of JdbcTemplate: " + e.getMessage());
            } else {
                System.out.println("Data access exception occurred: " + e.getMessage());
            }
        }

        return false;
    }

    @Override
    public Meal getMealById(int mealId) {
        Meal meal = null;
        String sql = "SELECT * FROM meal_history WHERE meal_history_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, mealId);
        if(results.next()) {
            meal = mapRowToMeals(results);
        }
        return meal;
    }

    public Meal mapRowToMeals(SqlRowSet rs) {
        Meal meal = new Meal();
        meal.setMealId(rs.getInt("meal_history_id"));
        java.sql.Date sqlDate = rs.getDate("meal_date");
        LocalDate localDate = sqlDate.toLocalDate();
        meal.setMealDate(localDate);
        meal.setType(rs.getString("type"));
        meal.setTotalCalories(rs.getInt("total_calories"));
        meal.setUserId(rs.getInt("user_id"));
        meal.setShowFoods(false);

        int mealId = meal.getMealId();
        List<Integer> foodIdList = getFoodIdsByMealId(mealId);
        List<Food> foodList = new ArrayList<>();
        //get food by id and then map it
        for(Integer foodId : foodIdList) {
            foodList.add(getFoodById(foodId));
        }

        meal.setFoodList(foodList);
        return meal;
    }

    public Food mapRowToFood(SqlRowSet rs) {
        Food food = new Food();
        food.setFoodId(rs.getInt("food_id"));
        food.setFoodName(rs.getString("food_name"));
        food.setCalories(rs.getInt("calories"));
        food.setServingSize(rs.getString("serving_size"));
        food.setNumberOfServings(rs.getInt("number_of_servings"));

        return food;
    }
}