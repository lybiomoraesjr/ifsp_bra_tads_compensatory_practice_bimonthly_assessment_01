package com.example.demo.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.dto.task.TaskRequestDto;
import com.example.demo.dto.task.TaskResponseDto;

public interface TaskService {
    List<TaskResponseDto> findAll();

    Optional<TaskResponseDto> findById(Long id);

    TaskResponseDto create(TaskRequestDto taskRequest);

    TaskResponseDto update(Long id, TaskRequestDto taskRequest);

    TaskResponseDto delete(Long id);
}
