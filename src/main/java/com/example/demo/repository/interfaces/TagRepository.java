package com.example.demo.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Tag;

public interface TagRepository {

    public Tag save(Tag tag);

    public Optional<Tag> findById(Long id);

    public List<Tag> findAll();

    public void deleteById(Long id);
} 