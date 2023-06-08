package com.techelevator.dao;

import com.techelevator.model.Mindfulness;

import javax.validation.constraints.Min;
import java.util.List;

public interface MindfulnessDao {

    List<Mindfulness> getActivities(int userId);

    int addMindful(Mindfulness mindfulness, int userId);

    Mindfulness getMindfulById(int mindfulId);


     
}
