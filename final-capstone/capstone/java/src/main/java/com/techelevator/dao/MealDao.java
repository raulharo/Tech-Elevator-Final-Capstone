package com.techelevator.dao;

import com.techelevator.model.Meal;

import java.util.List;

public interface MealDao {

    void addMeal(Meal meal, int userId);

    List<Meal> getMealsByUserId(int userId);
}
