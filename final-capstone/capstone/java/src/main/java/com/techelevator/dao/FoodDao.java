package com.techelevator.dao;

import com.techelevator.model.Food;

public interface FoodDao {
    public int createFood(Food food);

    public Food getFoodByID(int id);

    public boolean editFood(Food food);
}
