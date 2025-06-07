package com.example.demo.dto.task;

import com.example.demo.dto.location.LocationDto;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record TaskResponseDto(
    Long id,
    String title,
    String description,
    boolean done,
    String category,
    List<String> tags,
    LocalDateTime createdAt,
    LocalDate dueDate,
    LocationDto location
) {}