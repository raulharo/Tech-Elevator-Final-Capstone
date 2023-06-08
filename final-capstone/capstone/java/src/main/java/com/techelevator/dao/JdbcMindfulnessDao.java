package com.techelevator.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.model.Food;
import com.techelevator.model.Meal;
import com.techelevator.model.Mindfulness;
import org.springframework.dao.*;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMindfulnessDao implements MindfulnessDao {
    private JdbcTemplate jdbcTemplate;
    public JdbcMindfulnessDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Mindfulness> getActivities(int userId) {
        List<Mindfulness> mindfulList = new ArrayList<>();
        String sql = "SELECT * FROM mindful_history WHERE user_id = ?";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, userId);

            while (rowSet.next()) {
                mindfulList.add(mapRowToMindfulness(rowSet));
            }

            return mindfulList;
        }
        catch (DataAccessException e) {
            System.out.println("Could not connect to database.");
        }

        return null;
    }

    @Override
    public int addMindful(Mindfulness mindfulness, int userId) {

     String sql = "INSERT INTO mindful_history(activity, user_id, mindful_date, length_minutes) "
             + "VALUES(?, ?, NOW()::date, ?) RETURNING mindful_id;";

     try {
        Integer newMindfulId = jdbcTemplate.queryForObject(sql, Integer.class, mindfulness.getActivity(),
                userId, mindfulness.getLengthMinutes());
        return newMindfulId;
     } catch (DataAccessException e) {
         if (e instanceof CannotGetJdbcConnectionException) {
             System.out.println("Cannot get JDBC connection: " + e.getMessage());
         } else if (e instanceof DataIntegrityViolationException) {
             System.out.println("Data integrity violation: " + e.getMessage());
         } else if (e instanceof DuplicateKeyException) {
             System.out.println("Duplicate key violation: " + e.getMessage());
         } else if (e instanceof IncorrectResultSizeDataAccessException) {
             System.out.println("Incorrect result size: " + e.getMessage());
         } else if (e instanceof InvalidDataAccessApiUsageException) {
             System.out.println("Invalid usage of JdbcTemplate: " + e.getMessage());
         } else {
             System.out.println("Data access exception occurred: " + e.getMessage());
         }
     }

     return -1;
    }

    @Override
    public Mindfulness getMindfulById(int mindfulId) {
        Mindfulness mindfulness = new Mindfulness();
        String sql = "SELECT * FROM mindful_history WHERE mindful_id = ?";

        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, mindfulId);
            if (rowSet.next()) {
                mindfulness = mapRowToMindfulness(rowSet);
            }

            return mindfulness;
        }
        catch (DataAccessException e) {
            System.out.println("Could not connect to database");
        }

        return null;
    }

    public Mindfulness mapRowToMindfulness(SqlRowSet rowSet) {
        Mindfulness mindfulness = new Mindfulness();
        mindfulness.setMindfulId(rowSet.getInt("mindful_id"));
        mindfulness.setActivity(rowSet.getString("activity"));
        mindfulness.setUserId(rowSet.getInt("user_id"));
        mindfulness.setMindfulDate(rowSet.getDate("mindful_date").toLocalDate());
        mindfulness.setLengthMinutes(rowSet.getInt("length_minutes"));

        return mindfulness;
    }
}
