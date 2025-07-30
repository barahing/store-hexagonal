package com.example.storehexagonal.application.services;

import com.example.storehexagonal.domain.model.Category;
import com.example.storehexagonal.domain.ports.in.CategoryUseCase;
import com.example.storehexagonal.domain.ports.out.CategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements CategoryUseCase {
    private final CategoryRepositoryPort categoryRepositoryPort;

    public CategoryService(CategoryRepositoryPort categoryRepositoryPort) {
        this.categoryRepositoryPort = categoryRepositoryPort;
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepositoryPort.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepositoryPort.findAll();
    }
}
