package com.example.demo.mapper;

import com.example.demo.dto.category.CategoryRequestDto;
import com.example.demo.dto.category.CategoryResponseDto;
import com.example.demo.model.Category;
import com.example.demo.model.User;

public class CategoryMapper {
    
    public static CategoryResponseDto toResponseDto(Category category) {
        return new CategoryResponseDto(
            category.getId(),
            category.getName(),
            category.getUser() != null ? category.getUser().getId() : null
        );
    }

    public static Category toEntity(CategoryRequestDto dto, User user) {
        Category category = new Category();
        category.setName(dto.name());
        category.setUser(user);
        return category;
    }
} 