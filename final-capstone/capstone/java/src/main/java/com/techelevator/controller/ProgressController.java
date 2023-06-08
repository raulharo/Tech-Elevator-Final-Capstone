package com.techelevator.controller;

import com.techelevator.dao.ProgressDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.WeightsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ProgressController {

    @Autowired
    private UserDao userdao;

    @Autowired
    private ProgressDao progressDao;

    @GetMapping(value="day-calories")
    public int getTodayCalories(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getTodayCalories(userId);
    }

    @GetMapping(value="week-calories")
    public int getWeekCalories(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getWeekCalories(userId);
    }

    @GetMapping(value="month-calories")
    public int getMonthCalories(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getMonthCalories(userId);
    }

    @GetMapping(value="year-calories")
    public int getYearCalories(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getYearCalories(userId);
    }

    @GetMapping(value="lifetime-calories")
    public int getLifetimeCalories(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getLifetimeCalories(userId);
    }

    @GetMapping(value="day-mindful")
    public int getDayMindful(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getTodayMindfulMins(userId);
    }

    @GetMapping(value="week-mindful")
    public int getWeekMindful(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getWeekMindfulMins(userId);
    }

    @GetMapping(value="month-mindful")
    public int getMonthMindful(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getMonthMindfulMins(userId);
    }

    @GetMapping(value="year-mindful")
    public int getYearMindful(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getYearMindfulMins(userId);
    }

    @GetMapping(value="lifetime-mindful")
    public int getLifetimeMindful(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getLifetimeMindfulMins(userId);
    }
    @GetMapping (value="get-calorie-goal/")
    public int getCalorieGoal (Principal principal){
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getCalorieGoal(userId);
    }

    @GetMapping (value="get-mindful-goal/")
    public int getMindfulGoal (Principal principal){
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getMindfulGoal(userId);
    }

    @GetMapping (value = "get-weights")
    public WeightsDto getWeights(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return progressDao.getWeights(userId);
    }

    @PutMapping(value = "/update-weight", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateCurrentWeight(@RequestBody @Valid double weight, Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        if (!progressDao.updateWeight(weight, userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request: Update Failed");
        }
    }

}
