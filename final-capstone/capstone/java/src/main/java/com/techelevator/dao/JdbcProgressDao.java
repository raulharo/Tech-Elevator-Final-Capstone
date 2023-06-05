package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProgressDao implements ProgressDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcProgressDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int getTodayCalories(int userId) {
        int todayCalories = 0;
        String sql = "SELECT * FROM meal_history WHERE user_ID = ? AND meal_date = NOW()::date;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            todayCalories += results.getInt("calories");
        }
        return todayCalories;
    }

    @Override
    public int getWeekCalories(int userId) {
        int weekCalories = 0;
        String sql = "SELECT * FROM meal_history WHERE user_ID = ? AND meal_date BETWEEN (CURRENT_DATE - INTERVAL '1 week') AND CURRENT_DATE;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            weekCalories += results.getInt("calories");
        }
        return weekCalories;
    }

    public int getMonthCalories(int userId) {
        int monthCalories = 0;
        String sql = "SELECT * FROM meal_history WHERE user_ID = ? AND meal_date BETWEEN (CURRENT_DATE - INTERVAL '1 month') AND CURRENT_DATE;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            monthCalories += results.getInt("calories");
        }
        return monthCalories;
    }

    public int getYearCalories(int userId) {
        int yearCalories = 0;
        String sql = "SELECT * FROM meal_history WHERE user_ID = ? AND meal_date BETWEEN (CURRENT_DATE - INTERVAL '1 year') AND CURRENT_DATE;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            yearCalories += results.getInt("calories");
        }
        return yearCalories;
    }

    @Override
    public int getLifetimeCalories(int userId) {
        int lifetimeCalories = 0;
        String sql = "SELECT * FROM meal_history WHERE user_ID = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            lifetimeCalories += results.getInt("calories");
        }
        return lifetimeCalories;
    }

    public int getTodayMindfulMins(int userId) {
        int todayMindfulMins = 0;
        String sql = "SELECT * FROM mindful_history WHERE user_ID = ? AND mindful_date = NOW()::date;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            todayMindfulMins += results.getInt("length_minutes");
        }
        return todayMindfulMins;
    }

    @Override
    public int getWeekMindfulMins(int userId) {
        int weekMindfulMins = 0;
        String sql = "SELECT * FROM mindful_history WHERE user_ID = ? AND mindful_date BETWEEN (CURRENT_DATE - INTERVAL '1 week') AND CURRENT_DATE;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            weekMindfulMins += results.getInt("length_minutes");
        }
        return weekMindfulMins;
    }

    public int getMonthMindfulMins(int userId) {
        int monthCalories = 0;
        String sql = "SELECT * FROM mindful_history WHERE user_ID = ? AND mindful_date BETWEEN (CURRENT_DATE - INTERVAL '1 month') AND CURRENT_DATE;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            monthCalories += results.getInt("length_minutes");
        }
        return monthCalories;
    }

    public int getYearMindfulMins(int userId) {
        int yearMindfulMins = 0;
        String sql = "SELECT * FROM mindful_history WHERE user_ID = ? AND mindful_date BETWEEN (CURRENT_DATE - INTERVAL '1 year') AND CURRENT_DATE;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            yearMindfulMins += results.getInt("length_minutes");
        }
        return yearMindfulMins;
    }

    @Override
    public int getLifetimeMindfulMins(int userId) {
        int lifetimeMindfulMins = 0;
        String sql = "SELECT * FROM mindful_history WHERE user_ID = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            lifetimeMindfulMins += results.getInt("length_minutes");
        }
        return lifetimeMindfulMins;
    }

    @Override
    public int getMindfulGoal(int userId) {
        int mindfulGoal = 0;
        String sql = "SELECT * FROM profiles WHERE user_ID = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            mindfulGoal = results.getInt("mindful_goal");
        }
        return mindfulGoal;
    }

    @Override
    public int getCalorieGoal(int userId) {
        int calorieGoal = 0;
        String sql = "SELECT * FROM profiles WHERE user_ID = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()) {
            calorieGoal = results.getInt("calorie_limit");
        }
        return calorieGoal;
    }
}
