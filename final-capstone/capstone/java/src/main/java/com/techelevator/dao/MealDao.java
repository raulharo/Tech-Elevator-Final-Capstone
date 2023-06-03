package com.techelevator.dao;

import com.techelevator.model.Meal;

public interface MealDao {

    void addMeal(Meal meal, int userId);
}
