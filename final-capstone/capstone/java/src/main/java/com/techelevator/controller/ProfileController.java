package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class ProfileController {

    @Autowired
    private ProfileDao profileDao;




}
