package com.techelevator.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Food;
import com.techelevator.model.Meal;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMealDao implements MealDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addMeal(Meal meal, int userId) {
        Integer newMealId = 0;

        // add meal to the database AND grab meal id
        String sql = "INSERT INTO meal_history(user_id, meal_date, type, total_calories)" +
                "VALUES(?,?,?,?) RETURNING meal_id;";
        try {
            newMealId = jdbcTemplate.queryForObject(sql, Integer.class, userId, meal.getMealDate(), meal.getType(), meal.getTotalCalories());
        } catch (Exception e){
            System.out.println("An error occurred while attempting to add this meal to the database.");
        }
        // call method to add foods to db, retrieve and return their ids
        List<Integer> foodIdList = new ArrayList<>();
        for(Food food : meal.getFoodList()) {
            foodIdList.add(addFood(food));
        }

        // add meal id and food ids to associative table
        updateJunctionTable(newMealId, foodIdList);
    }

    public Integer addFood(Food food) {
        String sql = "INSERT INTO foods (food_name, calories, serving_size, number_of_servings)" +
                    " VALUES (?,?,?,?) RETURNING food_id;";

        try {
            Integer newFoodId = jdbcTemplate.queryForObject(sql, Integer.class, food.getFoodName(), food.getCalories(),
                            food.getServingSize(), food.getNumberOfServings());
            return newFoodId;
        }
        catch (Exception e) {
            System.out.println("An error occurred while attempting to add this food to the database.");
        }

        return -1;
    }

    public void updateJunctionTable(Integer mealId, List<Integer> foodIds) {
        String sql = "INSERT INTO meal_history_foods (meal_history_id, food_id)" +
                    " VALUES (?, ?);";

        try {
            for(Integer foodId : foodIds) {
                jdbcTemplate.queryForObject(sql, Integer.class, mealId, foodId);
            }
        }
        catch (Exception e) {
            System.out.println("An error occurred while attempting to add this record to the database.");
        }
    }
}
