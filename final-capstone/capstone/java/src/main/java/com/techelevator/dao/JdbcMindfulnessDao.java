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
        return null;
    }

    @Override
    public void addMindful(Mindfulness mindfulness, int userId) {

     String sql = "INSERT INTO mindful_history(activity, user_id, mindful_date, length_minutes) "
             + "VALUES(?, ?, NOW()::date, ?) RETURNING mindful_id;";

     try {
        Integer newMindfulId = jdbcTemplate.queryForObject(sql, Integer.class, mindfulness.getActivity(),
                userId, mindfulness.getLengthMinutes());
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

    }
}