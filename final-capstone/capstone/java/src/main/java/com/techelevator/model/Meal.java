package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class Meal {

    private int mealId;
    private LocalDate mealDate;
    @JsonProperty("mealType")
    private String type;
    private int userId;
    private int totalCalories;
    @JsonProperty("foods")
    private List<Food> foodList;
    private boolean showFoods = false;

    public Meal() {

    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public Meal(int mealId, LocalDate mealDate, String type, int totalCalories, List<Food> foodList, int userId) {
        this.mealId = mealId;
        this.mealDate = mealDate;
        this.type = type;
        this.totalCalories = totalCalories;
        this.foodList = foodList;
        this.userId = userId;
    }

    public Meal(LocalDate mealDate, String type, int totalCalories, List<Food> foodList) {
        this.mealDate = mealDate;
        this.type = type;
        this.totalCalories = totalCalories;
        this.foodList = foodList;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isShowFoods() {
        return showFoods;
    }

    public void setShowFoods(boolean showFoods) {
        this.showFoods = showFoods;
    }

    public LocalDate getMealDate() {
        return mealDate;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public List<Food> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
