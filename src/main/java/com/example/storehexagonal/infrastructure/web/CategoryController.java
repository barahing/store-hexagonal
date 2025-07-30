package com.example.storehexagonal.infrastructure.web;

import com.example.storehexagonal.application.services.CategoryService;
import com.example.storehexagonal.domain.model.Category;
import com.example.storehexagonal.domain.ports.in.CategoryUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryUseCase categoryService;

    public CategoryController(CategoryUseCase categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }
}
