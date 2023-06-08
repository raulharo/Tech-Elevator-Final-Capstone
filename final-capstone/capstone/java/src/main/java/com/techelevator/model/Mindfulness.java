package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Mindfulness {
    private String activity;
    private int mindfulId;
    private LocalDate mindfulDate;
    private int userId;
    @JsonProperty("minutes")
    private int lengthMinutes;

    public Mindfulness() {

    }

    public Mindfulness(String activity, int mindfulId, LocalDate mindfulDate, int userId, int lengthMinutes) {
        this.activity = activity;
        this.mindfulId = mindfulId;
        this.mindfulDate = mindfulDate;
        this.userId = userId;
        this.lengthMinutes = lengthMinutes;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public int getMindfulId() {
        return mindfulId;
    }

    public void setMindfulId(int mindfulId) {
        this.mindfulId = mindfulId;
    }

    public LocalDate getMindfulDate() {
        return mindfulDate;
    }

    public void setMindfulDate(LocalDate mindfulDate) {
        this.mindfulDate = mindfulDate;
    }

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

