package com.simbirsoft.habbitica.impl.controllers;

import com.simbirsoft.habbitica.api.services.TaskService;
import com.simbirsoft.habbitica.impl.models.data.Task;
import com.simbirsoft.habbitica.impl.models.dto.TaskDTO;
import com.simbirsoft.habbitica.impl.models.form.TaskForm;
import com.simbirsoft.habbitica.impl.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @PostMapping("/tasks/{task-id}")
    public String takeTask(@PathVariable("task-id") Long id,
                           @AuthenticationPrincipal UserDetailsImpl userDetails) {


        return "redirect:/tasks";
    }

    @GetMapping("/tasks/add")
    public String getTasksUploadPage(Model model) {

        model.addAttribute("taskForm", new TaskForm());

        return "tasks_upload_page";
    }

    @PostMapping("/tasks/add")
    public String addTask(@Valid TaskForm form) {

        Task task = Task.builder()
                .title(form.getTitle())
                .description(form.getDescription())
                .reward(form.getReward())
                .build();

        taskService.save(task);

        return "redirect:/tasks/add";
    }
}