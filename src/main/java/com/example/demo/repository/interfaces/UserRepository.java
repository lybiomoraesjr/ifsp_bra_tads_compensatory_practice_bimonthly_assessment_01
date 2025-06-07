package com.example.demo.repository.interfaces;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.User;

public interface UserRepository {

    public boolean existsByEmail(String email);

    public User save(User user);

    Optional<User> findById(Long id);
    
    public List<User> findAll();

    public void deleteById(Long id);

    public boolean existsById(Long id);

}
