package com.simbirsoft.habbitica.impl.controllers;

import com.simbirsoft.habbitica.api.services.AchievementService;
import com.simbirsoft.habbitica.api.services.TaskService;
import com.simbirsoft.habbitica.api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AchievementController {

    private AchievementService achievementService;
    private UserService userService;
    private TaskService taskService;

    @Autowired
    public AchievementController(AchievementService achievementService, UserService userService, TaskService taskService) {
        this.achievementService = achievementService;
        this.userService = userService;
        this.taskService = taskService;
    }
}
