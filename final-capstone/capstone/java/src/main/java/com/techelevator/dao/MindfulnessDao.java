package com.techelevator.dao;

import com.techelevator.model.Mindfulness;

import java.util.List;

public interface MindfulnessDao {

    List<Mindfulness> getActivities(int userId);

    void addMindful(Mindfulness mindfulness, int userId);




     
}
