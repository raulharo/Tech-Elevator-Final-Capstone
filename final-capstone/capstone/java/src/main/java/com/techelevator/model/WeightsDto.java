package com.techelevator.model;

public class WeightsDto {
    private double currentWeight;
    private double goalWeight;

    public WeightsDto(double currentWeight, double goalWeight) {
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
    }

    public WeightsDto() {
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
}
