package com.simbirsoft.habbitica.impl.controllers;

import com.simbirsoft.habbitica.api.services.TaskService;
import com.simbirsoft.habbitica.impl.models.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TasksController {

    private TaskService taskService;

    @Autowired
    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getTasksPage(Model model) {

        List<TaskDTO> tasks = taskService.findAll();
        model.addAttribute("tasks", tasks);

        return "tasks_page";
    }
}