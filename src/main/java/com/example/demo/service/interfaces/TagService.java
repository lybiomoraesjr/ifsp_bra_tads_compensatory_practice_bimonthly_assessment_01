package com.example.demo.service.interfaces;

import com.example.demo.dto.tag.TagRequestDto;
import com.example.demo.dto.tag.TagResponseDto;
import com.example.demo.model.Tag;

import java.util.List;
import java.util.Optional;

public interface TagService {
    List<TagResponseDto> findAll();
    Optional<TagResponseDto> findById(Long id);
    TagResponseDto create(TagRequestDto tagRequest);
    TagResponseDto update(Long id, TagRequestDto tagRequest);
    TagResponseDto delete(Long id);
    Tag findByIdEntity(Long id);
} 