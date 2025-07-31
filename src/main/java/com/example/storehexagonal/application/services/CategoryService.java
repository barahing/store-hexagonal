package com.example.storehexagonal.application.services;

import com.example.storehexagonal.domain.model.Category;
import com.example.storehexagonal.domain.ports.in.ICategoryUseCase;
import com.example.storehexagonal.domain.ports.out.ICategoryRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryUseCase {
    private final ICategoryRepositoryPort categoryRepositoryPort;

    public CategoryService(ICategoryRepositoryPort categoryRepositoryPort) {
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
