package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcProfileDao implements ProfileDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createProfile(Profile profile, int userId) {
        String sql = "INSERT INTO profiles(user_id, first_name, last_name, age, height, current_weight, goal_weight, calorie_limit, mindful_goal) " +
                "VALUES(?,?,?,?,?,?,?,?,?) " +
                "RETURNING profile_id;";
        try {
            int newProfileId = jdbcTemplate.queryForObject(sql, int.class, userId, profile.getFirstName(), profile.getLastName(), profile.getAge(), profile.getHeight(), profile.getCurrentWeight(), profile.getGoalWeight(), profile.getCalorieLimit(), profile.getMindfulGoal());
        } catch(Exception e){
            System.out.println("An error occurred while trying to add this profile to the database.");
        }

    }

}
