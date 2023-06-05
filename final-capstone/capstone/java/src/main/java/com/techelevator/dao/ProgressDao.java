package com.techelevator.dao;

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

}
