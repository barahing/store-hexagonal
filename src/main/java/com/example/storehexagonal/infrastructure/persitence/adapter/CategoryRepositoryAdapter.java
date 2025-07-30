package com.example.storehexagonal.infrastructure.persitence.adapter;

import com.example.storehexagonal.domain.model.Category;
import com.example.storehexagonal.domain.ports.out.CategoryRepositoryPort;
import com.example.storehexagonal.infrastructure.persitence.entity.CategoryEntity;
import com.example.storehexagonal.infrastructure.persitence.jpa.JpaCategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {
    private final JpaCategoryRepository jpaCategoryRepository;

    public CategoryRepositoryAdapter(JpaCategoryRepository jpaCategoryRepository) {
        this.jpaCategoryRepository = jpaCategoryRepository;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setName(category.getName());
        CategoryEntity categoryEntitySaved = jpaCategoryRepository.save(categoryEntity);
        return new Category(categoryEntitySaved.getId(), categoryEntitySaved.getName());
    }

    @Override
    public List<Category> findAll() {
        return jpaCategoryRepository.findAll().stream().map(e -> new Category(e.getId(), e.getName())).collect(Collectors.toList());
    }
}
