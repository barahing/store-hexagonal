package com.example.storehexagonal.infrastructure.persitence.mapper;

import com.example.storehexagonal.domain.model.Category;
import com.example.storehexagonal.infrastructure.persitence.entity.CategoryEntity;
import com.example.storehexagonal.infrastructure.web.dto.CategoryRequestDTO;
import com.example.storehexagonal.infrastructure.web.dto.CategoryResponseDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    // Domain <-> Entity
    Category toDomain(CategoryEntity categoryEntity);
    CategoryEntity toEntity(Category category);

    // Domain <-> DTO
    Category toDomain(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO toResponseDTO(Category category);
    List<CategoryResponseDTO> toResponseDTOList(List<Category> categories);
}
