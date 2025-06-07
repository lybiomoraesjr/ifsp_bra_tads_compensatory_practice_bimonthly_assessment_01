package com.example.demo.dto.tag;

import jakarta.validation.constraints.NotBlank;

public record TagRequestDto(
    @NotBlank(message = "O nome da tag é obrigatório.")
    String name
) {} 