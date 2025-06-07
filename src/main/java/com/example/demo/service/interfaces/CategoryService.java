package com.example.demo.service.interfaces;

import com.example.demo.dto.category.CategoryRequestDto;
import com.example.demo.dto.category.CategoryResponseDto;
import com.example.demo.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryResponseDto> findAll();
    Optional<CategoryResponseDto> findById(Long id);
    CategoryResponseDto create(CategoryRequestDto categoryRequest);
    CategoryResponseDto update(Long id, CategoryRequestDto categoryRequest);
    CategoryResponseDto delete(Long id);
    Category findByIdEntity(Long id);
} 