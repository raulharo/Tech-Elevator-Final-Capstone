package com.techelevator.model;

public class WeightsDto {
    private double initialWeight;
    private double currentWeight;
    private double goalWeight;

    public WeightsDto(double initialWeight, double currentWeight, double goalWeight) {
        this.initialWeight = initialWeight;
        this.currentWeight = currentWeight;
        this.goalWeight = goalWeight;
    }

    public WeightsDto() {
    }

    public double getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(double initialWeight) {
        this.initialWeight = initialWeight;
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
