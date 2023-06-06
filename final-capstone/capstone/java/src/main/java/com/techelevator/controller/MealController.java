package com.techelevator.controller;

import com.techelevator.dao.FoodDao;
import com.techelevator.dao.MealDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.DeleteRecord;
import com.techelevator.model.Food;
import com.techelevator.model.Meal;
import com.techelevator.model.MealDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class MealController {

    @Autowired
    private MealDao mealDao;

    @Autowired
    private FoodDao foodDao;

    @Autowired
    private UserDao userdao;

    @PostMapping(value="create-meal")
    public void createMeal(@RequestBody @Valid Meal meal, Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        mealDao.addMeal(meal, userId);
    }

    @GetMapping(value="get-meals")
    public List<Meal> getMeals(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return mealDao.getMealsByUserId(userId);

    }

    @PutMapping(value = "update-food")
    public void updateFood(@RequestBody @Valid Food food) {
        if (!foodDao.editFood(food)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Food update failed");
        }
    }

    @PutMapping(value = "update-meal")
    public void updateMeal(@RequestBody @Valid MealDto meal, Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        if (!mealDao.updateMeal(meal, userId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Meal update failed");
        }
    }

    @DeleteMapping(value = "delete-meal")
    public void deleteMeal(@RequestBody @Valid DeleteRecord record) {
        if(!mealDao.deleteMeal(record.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Could not delete record");
        }
    }
}
