package com.codexasistemas.todoapp.api.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.codexasistemas.todoapp.api.model.Task;

public interface TaskRepository {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();
    void deleteById(Long id);
    List<Task> findByUserId(Long userId);
}