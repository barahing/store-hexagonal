package com.example.storehexagonal.domain.ports.out;

import com.example.storehexagonal.domain.model.Category;

import java.util.List;

public interface CategoryRepositoryPort {
    Category save(Category category);
    List<Category> findAll();
}
