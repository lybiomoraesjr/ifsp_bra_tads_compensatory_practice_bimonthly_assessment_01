package com.example.demo.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    public boolean existsByEmail(String email);

}
