package com.simbirsoft.habbitica.api.repositories;

import com.simbirsoft.habbitica.impl.models.data.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}