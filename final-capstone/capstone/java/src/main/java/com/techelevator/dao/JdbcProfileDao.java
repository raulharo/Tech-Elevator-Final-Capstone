package com.techelevator.dao;

import com.techelevator.model.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcProfileDao implements ProfileDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcProfileDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createProfile(Profile profile, int userId) {
        String sql = "INSERT INTO profiles(user_id, first_name, last_name, age, height, current_weight, goal_weight, calorie_limit, mindful_goal, profile_picture) " +
                "VALUES(?,?,?,?,?,?,?,?,?,?) " +
                "RETURNING profile_id;";
        try {
            int newProfileId = jdbcTemplate.queryForObject(sql, int.class, userId, profile.getFirstName(), profile.getLastName(), profile.getAge(), profile.getHeight(), profile.getCurrentWeight(), profile.getGoalWeight(), profile.getCalorieLimit(), profile.getMindfulGoal(), profile.getProfilePicture());
        } catch(Exception e){
            System.out.println("An error occurred while trying to add this profile to the database.");
        }
    }

    @Override
    public void editProfile(Profile profile, int userId) {
        String sql = "UPDATE profiles SET first_name = ?, last_name= ?, age= ?, height= ?, current_weight= ?, goal_weight= ?, calorie_limit= ?, mindful_goal= ?, profile_picture= ? WHERE user_id = ?;";
        try {
            jdbcTemplate.update(sql, profile.getFirstName(), profile.getLastName(), profile.getAge(), profile.getHeight(), profile.getCurrentWeight(), profile.getGoalWeight(), profile.getCalorieLimit(), profile.getMindfulGoal(), profile.getProfilePicture(), userId);
        } catch(Exception e){
            System.out.println("An error occurred while trying to edit this profile in the database.");
        }
    }

    @Override
    public Profile getProfileByUserId(int userId) {
        Profile profile = null;
        String sql = "SELECT * FROM profiles WHERE user_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        if (results.next()) {
            profile = mapRowToProfile(results);
        }
        return profile;
    }

    private Profile mapRowToProfile(SqlRowSet rs) {
        Profile profile = new Profile();
        profile.setFirstName(rs.getString("first_name"));
        profile.setLastName(rs.getString("last_name"));
        profile.setAge(rs.getInt("age"));
        profile.setHeight(rs.getInt("height"));
        profile.setCurrentWeight(rs.getDouble("current_weight"));
        profile.setGoalWeight(rs.getDouble("goal_weight"));
        profile.setCalorieLimit(rs.getInt("calorie_limit"));
        profile.setMindfulGoal(rs.getInt("mindful_goal"));
        profile.setProfilePicture(rs.getString("profile_picture"));

        return profile;
    }

}
