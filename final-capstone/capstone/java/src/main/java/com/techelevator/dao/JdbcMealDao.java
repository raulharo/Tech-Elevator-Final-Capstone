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
    private ObjectMapper objectMapper;

    public JdbcMealDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void addMeal(Meal meal, int userId) {

        // add meal to the database AND grab meal id
        String sql = "INSERT INTO meal_history(user_id, meal_date, type, total_calories)" +
                "VALUES(?,?,?,?) RETURNING meal_id;";
        try {
            int newMealId = jdbcTemplate.queryForObject(sql,int.class, userId, meal.getMealDate(), meal.getType(), meal.getTotalCalories());
        } catch (Exception e){
            System.out.println("An error occurred while attempting to add this meal to the database.");
        }
        // call method to add foods to db, retrieve and return their ids
        List<Integer> foodIdList = new ArrayList<>();
        for(Food food : meal.getFoodList()) {

        }

        // add meal id and food ids to associative table
    }

    public List<Integer> getFoodList(Meal meal) {

    }

    public void updateJunctionTable(mealId, foodIds) {

    }
}
