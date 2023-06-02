package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Food {
    @JsonProperty("food_id")
    private int foodId;
    @JsonProperty("food_name")
    private String foodName;
    private int calories;
    @JsonProperty("serving_size")
    private String servingSize;
    @JsonProperty("number_of_servings")
    private int numberOfServings;

    public Food(int foodId, String foodName, int calories, String servingSize, int numberOfServings) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.calories = calories;
        this.servingSize = servingSize;
        this.numberOfServings = numberOfServings;
    }

    public Food() {
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getServingSize() {
        return servingSize;
    }

    public void setServingSize(String servingSize) {
        this.servingSize = servingSize;
    }

    public int getNumberOfServings() {
        return numberOfServings;
    }

    public void setNumberOfServings(int numberOfServings) {
        this.numberOfServings = numberOfServings;
    }
}
