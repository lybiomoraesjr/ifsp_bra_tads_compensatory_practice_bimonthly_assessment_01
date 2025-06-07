package com.example.demo.repository.interfaces;

import com.example.demo.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    public Category save(Category category);

    public Optional<Category> findById(Long id);

    public List<Category> findAll();

    public void deleteById(Long id);
} 