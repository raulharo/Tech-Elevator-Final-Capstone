package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class Meal {

    private LocalDate mealDate;
    private String type;
    private int totalCalories;
    @JsonProperty("foods")
    private List<Food> foodList;

    public Meal() {

    }

    public Meal(LocalDate mealDate, String type, int totalCalories, List<Food> foodList) {
        this.mealDate = mealDate;
        this.type = type;
        this.totalCalories = totalCalories;
        this.foodList = foodList;
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
