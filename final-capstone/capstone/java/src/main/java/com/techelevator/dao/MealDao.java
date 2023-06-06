package com.techelevator.dao;

import com.techelevator.model.Meal;
import com.techelevator.model.MealDto;

import java.util.List;

public interface MealDao {

    void addMeal(Meal meal, int userId);

    List<Meal> getMealsByUserId(int userId);

    boolean updateMeal(MealDto meal, int userId);
}
