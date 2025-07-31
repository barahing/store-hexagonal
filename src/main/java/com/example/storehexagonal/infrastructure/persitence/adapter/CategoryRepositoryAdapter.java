package com.example.storehexagonal.infrastructure.persitence.adapter;

import com.example.storehexagonal.domain.model.Category;
import com.example.storehexagonal.domain.ports.out.ICategoryRepositoryPort;
import com.example.storehexagonal.infrastructure.persitence.entity.CategoryEntity;
import com.example.storehexagonal.infrastructure.persitence.jpa.JpaCategoryRepository;
import com.example.storehexagonal.infrastructure.persitence.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CategoryRepositoryAdapter implements ICategoryRepositoryPort {
    private final JpaCategoryRepository jpaCategoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryRepositoryAdapter(JpaCategoryRepository jpaCategoryRepository, CategoryMapper categoryMapper) {
        this.jpaCategoryRepository = jpaCategoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        CategoryEntity categoryEntity = categoryMapper.toEntity(category);
        return categoryMapper.toDomain(jpaCategoryRepository.save(categoryEntity));
    }

    @Override
    public List<Category> findAll() {
        return jpaCategoryRepository.findAll().stream().map(categoryMapper::toDomain).collect(Collectors.toList());
    }
}
