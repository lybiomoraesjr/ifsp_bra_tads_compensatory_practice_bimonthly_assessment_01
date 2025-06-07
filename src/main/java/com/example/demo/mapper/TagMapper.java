package com.example.demo.mapper;

import com.example.demo.dto.tag.TagRequestDto;
import com.example.demo.dto.tag.TagResponseDto;
import com.example.demo.model.Tag;

public class TagMapper {
    
    public static TagResponseDto toResponseDto(Tag tag) {
        return new TagResponseDto(
            tag.getId(),
            tag.getName()
        );
    }

    public static Tag toEntity(TagRequestDto dto) {
        Tag tag = new Tag();
        tag.setName(dto.name());
        return tag;
    }
} 