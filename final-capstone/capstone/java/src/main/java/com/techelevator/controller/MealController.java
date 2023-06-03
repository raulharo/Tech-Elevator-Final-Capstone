package com.techelevator.controller;

import com.techelevator.dao.MealDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Food;
import com.techelevator.model.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class MealController {

    @Autowired
    private MealDao mealDao;

    @Autowired
    private UserDao userdao;

    @PostMapping(value="create-meal")
    public void createMeal(@RequestBody @Valid Meal meal, Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        mealDao.addMeal(meal, userId);
    }


}
