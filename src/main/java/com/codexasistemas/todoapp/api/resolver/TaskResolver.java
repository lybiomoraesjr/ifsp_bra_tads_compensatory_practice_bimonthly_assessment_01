package com.codexasistemas.todoapp.api.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import com.codexasistemas.todoapp.api.dto.task.TaskRequestDto;
import com.codexasistemas.todoapp.api.dto.task.TaskResponseDto;
import com.codexasistemas.todoapp.api.service.interfaces.TaskService;

@org.springframework.stereotype.Controller
public class TaskResolver {

    @Autowired
    private TaskService taskService;

    @QueryMapping
    public List<TaskResponseDto> getAllTasks() {
        return taskService.findAll();
    }

    @QueryMapping
    public TaskResponseDto getTaskById(@Argument Long id) {
        return taskService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }

    @QueryMapping
    public List<TaskResponseDto> getTasksByUserId(@Argument Long userId) {
        return taskService.findByUserId(userId);
    }

    @MutationMapping
    public TaskResponseDto createTask(@Argument TaskRequestDto taskInput) {
        return taskService.create(taskInput);
    }

    @MutationMapping
    public TaskResponseDto updateTask(@Argument Long id, @Argument TaskRequestDto taskInput) {
        return taskService.update(id, taskInput);
    }

    @MutationMapping
    public TaskResponseDto deleteTask(@Argument Long id) {
        return taskService.delete(id);
    }

    @MutationMapping
    public TaskResponseDto toggleTaskStatus(@Argument Long id) {
        return taskService.toggleStatus(id);
    }
}
