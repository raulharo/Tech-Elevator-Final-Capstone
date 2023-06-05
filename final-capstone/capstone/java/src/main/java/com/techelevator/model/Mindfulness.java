package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Mindfulness {
    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private double currentWeight;
    private double goalWeight;
    private int calorieLimit;
    private int mindfulGoal;
    private String activity;
    private int mindfulId;
    private int userId;
    @JsonProperty("minutes")
    private int lengthMinutes;

    public Mindfulness() {

    }

    public Mindfulness(String activity, int userId, int lengthMinutes) {
        //this.firstName = firstName;
        //this.lastName = lastName;
        //this.age = age;
        //this.height = height;
        //this.currentWeight = currentWeight;
        //this.goalWeight = goalWeight;
        //this.calorieLimit = calorieWeight;
        //this.mindfulGoal = mindfulGoal;
        this.activity = activity;
        //this.mindfulId = mindfulId;
        this.userId = userId;
        this.lengthMinutes = lengthMinutes;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public double getGoalWeight() {
        return goalWeight;
    }

    public void setGoalWeight(double goalWeight) {
        this.goalWeight = goalWeight;
    }

    public int getCalorieLimit() {
        return calorieLimit;
    }

    public void setCalorieLimit(int calorieWeight) {
        this.calorieLimit = calorieWeight;
    }

    public int getMindfulGoal() {
        return mindfulGoal;
    }

    public void setMindfulGoal(int mindfulGoal) {
        this.mindfulGoal = mindfulGoal;
    }

    public String getActivity() { return activity; }

    public void setActivity(String activity) { this.activity = activity; }

    public int getMindfulId() { return  mindfulId; }

    public void setMindfulId(int mindfulId) {this.mindfulId = mindfulId; }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public void setLengthMinutes(int lengthMinutes) {
        this.lengthMinutes = lengthMinutes;
    }
}

