package com.example.demo.service.interfaces;

import com.example.demo.dto.user.UserRequestDto;
import com.example.demo.dto.user.UserResponseDto;
import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> findAll();
    UserResponseDto findById(Long id);
    User findByIdEntity(Long id);
    UserResponseDto save(UserRequestDto userInfo);
    UserResponseDto update(UserRequestDto userInfo);
    UserResponseDto deleteById(Long id);
} 