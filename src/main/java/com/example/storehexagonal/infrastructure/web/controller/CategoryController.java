package com.example.storehexagonal.infrastructure.web.controller;

import com.example.storehexagonal.domain.model.Category;
import com.example.storehexagonal.domain.ports.in.ICategoryUseCase;
import com.example.storehexagonal.infrastructure.persitence.mapper.CategoryMapper;
import com.example.storehexagonal.infrastructure.web.dto.CategoryRequestDTO;
import com.example.storehexagonal.infrastructure.web.dto.CategoryResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final ICategoryUseCase categoryService;
    private final CategoryMapper categoryMapper;

    public CategoryController(ICategoryUseCase categoryService, CategoryMapper categoryMapper) {
        this.categoryService = categoryService;
        this.categoryMapper = categoryMapper;
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAllCategories() {
        return ResponseEntity.ok(categoryMapper.toResponseDTOList(categoryService.getAllCategories()));
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@Valid @RequestBody CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryMapper.toDomain(categoryRequestDTO);
        return ResponseEntity.ok(categoryMapper.toResponseDTO(categoryService.createCategory(category)));
    }
}
