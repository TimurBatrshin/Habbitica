package com.simbirsoft.habbitica.impl.services;

import com.simbirsoft.habbitica.api.repositories.TaskRepository;
import com.simbirsoft.habbitica.api.services.TaskService;
import com.simbirsoft.habbitica.impl.models.data.Task;
import com.simbirsoft.habbitica.impl.models.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.simbirsoft.habbitica.impl.models.dto.TaskDTO.from;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<TaskDTO> findAll() {
        return from(taskRepository.findAll());
    }
}