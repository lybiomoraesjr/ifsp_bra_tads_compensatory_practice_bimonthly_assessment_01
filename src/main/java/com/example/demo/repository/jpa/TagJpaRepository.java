package com.example.demo.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Tag;

public interface TagJpaRepository extends JpaRepository<Tag, Long> {
    
}
