package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private ProfileDao profileDao;

    @PostMapping(value="createProfile")
    public void createProfile(@Valid @RequestBody Profile profile) {
        profileDao.createProfile(profile);

    }


}
