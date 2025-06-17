package com.codexasistemas.todoapp.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codexasistemas.todoapp.api.model.Task;

import java.util.List;

public interface TaskJpaRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}