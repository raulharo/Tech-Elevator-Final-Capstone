package com.techelevator.dao;

import com.techelevator.model.WeightsDto;

public interface ProgressDao {

    int getTodayCalories(int userId);

    int getWeekCalories(int userId);

    int getMonthCalories(int userId);

    int getYearCalories(int userId);

    int getLifetimeCalories(int userId);

    int getTodayMindfulMins(int userId);

    int getWeekMindfulMins(int userId);

    int getMonthMindfulMins(int userId);

    int getYearMindfulMins(int userId);

    int getLifetimeMindfulMins(int userId);

    int getMindfulGoal(int userId);

    int getCalorieGoal (int userId);

    WeightsDto getWeights (int userId);

    boolean updateWeight(double weight, int userId);
}
