package com.techelevator.model;

import java.time.LocalDate;

public class MealDto {
    private int mealId;
    private LocalDate mealDate;
    private String mealType;
    private int totalCalories;

    public MealDto(int mealId, LocalDate mealDate, String mealType, int totalCalories) {
        this.mealId = mealId;
        this.mealDate = mealDate;
        this.mealType = mealType;
        this.totalCalories = totalCalories;
    }

    public MealDto() {
    }

    public int getMealId() {
        return mealId;
    }

    public void setMealId(int mealId) {
        this.mealId = mealId;
    }

    public LocalDate getMealDate() {
        return mealDate;
    }

    public void setMealDate(LocalDate mealDate) {
        this.mealDate = mealDate;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }
}
