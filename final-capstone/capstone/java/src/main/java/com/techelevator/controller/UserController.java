package com.techelevator.controller;

import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private UserDao userdao;


    @PostMapping(value="create-profile")
    public void createProfile(@Valid @RequestBody Profile profile, Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        profileDao.createProfile(profile, userId);

    }

    @PutMapping(value="edit-profile")
    public void editProfile(@Valid @RequestBody Profile profile, Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        profileDao.editProfile(profile, userId);

    }

    @GetMapping(value="get-profile")
    public Profile getProfile(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return profileDao.getProfileByUserId(userId);

    }
    @DeleteMapping (value="delete-user")
    public Profile deleteUser ()

}
