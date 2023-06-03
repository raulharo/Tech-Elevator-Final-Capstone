package com.techelevator.dao;

import com.techelevator.model.Food;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcFoodDao implements FoodDao {
    private JdbcTemplate jdbcTemplate;

    public JdbcFoodDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createFood(Food food) {
        String sql = "INSERT INTO foods (food_name, calories, serving_size)" +
                    " VALUES (?, ?, ?) RETURNING food_id";

        try {
            int returnedFoodId = jdbcTemplate.queryForObject(sql, Integer.class, food.getFoodName(),
                                 food.getCalories(), food.getServingSize());
            return returnedFoodId;
        }
        catch (DataAccessException e) {
            System.err.println("Error connecting to database.");
        }

        return -1;
    }

    @Override
    public Food getFoodByID(int id) {
        return null;
    }

    @Override
    public boolean editFood(Food food) {
        return false;
    }
}
