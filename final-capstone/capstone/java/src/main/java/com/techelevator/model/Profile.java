package com.techelevator.model;

public class Profile {
    private String firstName;
    private String lastName;
    private int age;
    private int height;
    private double initialWeight;
    private double currentWeight;
    private double goalWeight;
    private int calorieLimit;
    private int mindfulGoal;
    private String profilePicture;

    public Profile() {

    }

    public Profile(String firstName, String lastName, int age, int height, double initialWeight, double currentWeight, double goalWeight, int calorieWeight, int mindfulGoal, String profilePicture) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.height = height;
        this.initialWeight = initialWeight;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
        this.calorieLimit = calorieWeight;
        this.mindfulGoal = mindfulGoal;
        this.profilePicture = profilePicture;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public double getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(double initialWeight) {
        this.initialWeight = initialWeight;
    }

    public String getFirstName() {
        return firstName;
    }

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
}
