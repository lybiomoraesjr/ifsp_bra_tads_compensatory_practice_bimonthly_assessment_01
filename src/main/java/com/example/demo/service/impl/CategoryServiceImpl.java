package com.example.demo.service.impl;

import com.example.demo.dto.category.CategoryRequestDto;
import com.example.demo.dto.category.CategoryResponseDto;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.repository.interfaces.CategoryRepository;
import com.example.demo.service.interfaces.CategoryService;
import com.example.demo.service.interfaces.UserService;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
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
} 