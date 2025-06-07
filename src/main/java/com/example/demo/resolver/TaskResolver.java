package com.example.demo.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;

import com.example.demo.dto.task.TaskResponseDto;
import com.example.demo.service.interfaces.TaskService;

@org.springframework.stereotype.Controller
public class TaskResolver {

    private final TaskService taskService;

    public TaskResolver(TaskService taskService) {
        this.taskService = taskService;
    }

    @QueryMapping
    public List<TaskResponseDto> getAllTasks() {
        return taskService.findAll();
    }

    @QueryMapping
    public TaskResponseDto getTaskById(@Argument Long id) {
        return taskService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
    }
}
