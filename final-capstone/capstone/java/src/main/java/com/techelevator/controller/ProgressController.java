package com.techelevator.controller;

import com.techelevator.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ProgressController {

    @Autowired
    private UserDao userdao;

    @GetMapping(value="todays-calories")
    public int getTodaysCalories(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
    }


}
