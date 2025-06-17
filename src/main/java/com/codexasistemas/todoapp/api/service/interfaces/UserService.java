package com.codexasistemas.todoapp.api.service.interfaces;

import java.util.List;

import com.codexasistemas.todoapp.api.dto.category.CategoryWithTaskCountDto;
import com.codexasistemas.todoapp.api.dto.tag.TagWithTaskCountDto;
import com.codexasistemas.todoapp.api.dto.task.TaskResponseDto;
import com.codexasistemas.todoapp.api.dto.user.UserRequestDto;
import com.codexasistemas.todoapp.api.dto.user.UserResponseDto;
import com.codexasistemas.todoapp.api.model.User;

public interface UserService {
    List<UserResponseDto> findAll();

    UserResponseDto findById(Long id);

    User findByIdEntity(Long id);

    UserResponseDto save(UserRequestDto userInfo);

    UserResponseDto update(UserRequestDto userInfo);

    UserResponseDto deleteById(Long id);

    List<CategoryWithTaskCountDto> findCategoriesWithTaskCount(Long userId);

    List<TagWithTaskCountDto> findTagsWithTaskCount(Long userId);

    List<TaskResponseDto> findTasksWithTaskCount(Long userId);

    List<TaskResponseDto> findTasksWithContext(Long userId);
}