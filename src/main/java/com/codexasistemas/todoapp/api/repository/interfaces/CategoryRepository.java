package com.codexasistemas.todoapp.api.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.codexasistemas.todoapp.api.model.Category;

public interface CategoryRepository {
    public Category save(Category category);

    public Optional<Category> findById(Long id);

    public List<Category> findAll();

    public void deleteById(Long id);

    public List<Category> findByUserId(Long userId);
} 