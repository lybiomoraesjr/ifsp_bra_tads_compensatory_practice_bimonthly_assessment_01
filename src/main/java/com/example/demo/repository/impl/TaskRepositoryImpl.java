package com.example.demo.repository.impl;

import com.example.demo.model.Task;
import com.example.demo.repository.interfaces.TaskRepository;
import com.example.demo.repository.jpa.TaskJpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final TaskJpaRepository jpa;

    public TaskRepositoryImpl(TaskJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Task save(Task task) {
        return jpa.save(task);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public List<Task> findAll() {
        return jpa.findAll();
    } 

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }

    @Override
    public List<Task> findByUserId(Long userId) {
        return jpa.findByUserId(userId);
    }
}