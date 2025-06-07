package com.example.demo.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Tag;
import com.example.demo.repository.interfaces.TagRepository;
import com.example.demo.repository.jpa.TagJpaRepository;

@Repository
public class TagRepositoryImpl implements TagRepository {

    private final TagJpaRepository jpa;

    public TagRepositoryImpl(TagJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    public Tag save(Tag tag) {
        return jpa.save(tag);
    }

    @Override
    public Optional<Tag> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public List<Tag> findAll() {
        return jpa.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpa.deleteById(id);
    }
}
