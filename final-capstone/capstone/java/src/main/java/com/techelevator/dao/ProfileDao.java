package com.techelevator.dao;

import com.techelevator.model.Profile;

public interface ProfileDao {

    void createProfile(Profile profile, int userId);

    void editProfile(Profile profile, int userId);

    Profile getProfileByUserId(int userId);
}
