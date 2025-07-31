package com.example.storehexagonal.domain.ports.in;

import com.example.storehexagonal.domain.model.Category;

import java.util.List;

public interface ICategoryUseCase {
    Category createCategory(Category category);
    List<Category> getAllCategories();
}
