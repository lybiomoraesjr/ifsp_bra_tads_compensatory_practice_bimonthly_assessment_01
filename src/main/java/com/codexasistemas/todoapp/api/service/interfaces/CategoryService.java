package com.codexasistemas.todoapp.api.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.codexasistemas.todoapp.api.dto.category.CategoryRequestDto;
import com.codexasistemas.todoapp.api.dto.category.CategoryResponseDto;
import com.codexasistemas.todoapp.api.dto.task.TaskResponseDto;
import com.codexasistemas.todoapp.api.model.Category;

public interface CategoryService {
    List<CategoryResponseDto> findAll();
    Optional<CategoryResponseDto> findById(Long id);
    CategoryResponseDto create(CategoryRequestDto categoryRequest);
    CategoryResponseDto update(Long id, CategoryRequestDto categoryRequest);
    CategoryResponseDto delete(Long id);
    Category findByIdEntity(Long id);
    
    List<TaskResponseDto> findTasksByCategory(Long categoryId);
    List<CategoryResponseDto> findByUserId(Long userId);
} 