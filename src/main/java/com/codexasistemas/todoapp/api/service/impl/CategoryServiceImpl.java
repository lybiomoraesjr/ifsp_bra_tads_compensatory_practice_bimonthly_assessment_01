package com.codexasistemas.todoapp.api.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codexasistemas.todoapp.api.dto.category.CategoryRequestDto;
import com.codexasistemas.todoapp.api.dto.category.CategoryResponseDto;
import com.codexasistemas.todoapp.api.dto.task.TaskResponseDto;
import com.codexasistemas.todoapp.api.mapper.CategoryMapper;
import com.codexasistemas.todoapp.api.mapper.TaskMapper;
import com.codexasistemas.todoapp.api.model.Category;
import com.codexasistemas.todoapp.api.model.User;
import com.codexasistemas.todoapp.api.repository.interfaces.CategoryRepository;
import com.codexasistemas.todoapp.api.service.interfaces.CategoryService;
import com.codexasistemas.todoapp.api.service.interfaces.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserService userService;

    @Override
    public List<CategoryResponseDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CategoryResponseDto> findById(Long id) {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toResponseDto);
    }

    @Override
    public CategoryResponseDto create(CategoryRequestDto categoryRequest) {
        User user = userService.findByIdEntity(categoryRequest.userId());
        Category category = CategoryMapper.toEntity(categoryRequest, user);
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.toResponseDto(savedCategory);
    }

    @Override
    public CategoryResponseDto delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada: " + id));
        CategoryResponseDto responseDto = CategoryMapper.toResponseDto(category);
        categoryRepository.deleteById(category.getId());
        return responseDto;
    }

    @Override
    public Category findByIdEntity(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada: " + id));
    }

    @Override
    public CategoryResponseDto update(Long id, CategoryRequestDto categoryRequest) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada: " + id));

        User user = userService.findByIdEntity(categoryRequest.userId());
        existingCategory.setName(categoryRequest.name());
        existingCategory.setUser(user);

        Category updatedCategory = categoryRepository.save(existingCategory);
        return CategoryMapper.toResponseDto(updatedCategory);
    }

    @Override
    public List<TaskResponseDto> findTasksByCategory(Long categoryId) {
        Category category = findByIdEntity(categoryId);
        return category.getTasks().stream()
            .map(TaskMapper::toResponseDto)
            .collect(Collectors.toList());
    }

    @Override
    public List<CategoryResponseDto> findByUserId(Long userId) {
        return categoryRepository.findByUserId(userId).stream()
                .map(CategoryMapper::toResponseDto)
                .collect(Collectors.toList());
    }
} 