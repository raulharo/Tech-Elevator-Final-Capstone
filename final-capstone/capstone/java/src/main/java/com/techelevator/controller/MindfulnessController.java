package com.techelevator.controller;

import com.techelevator.dao.MindfulnessDao;
import com.techelevator.dao.ProfileDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Mindfulness;
import com.techelevator.model.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@CrossOrigin
public class MindfulnessController {

    @Autowired
    private MindfulnessDao mindfulnessDao;

    @Autowired
    private UserDao userdao;

    @PostMapping(value="mindfulness")
    public int createMindful(@RequestBody @Valid Mindfulness mindfulness, Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return mindfulnessDao.addMindful(mindfulness, userId);
    }

    @GetMapping(value="get-mindful")
    public List<Mindfulness> getMindful(Principal principal) {
        String username = principal.getName();
        int userId = userdao.findIdByUsername(username);
        return mindfulnessDao.getActivities(userId);
    }

    @GetMapping(value = "get-mindful/{mindfulId}")
    public Mindfulness getSingleMindfulness(@PathVariable @Valid int mindfulId) {
        return mindfulnessDao.getMindfulById(mindfulId);
    }
}
