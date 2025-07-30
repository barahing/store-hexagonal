package com.example.storehexagonal.infrastructure.persitence.jpa;

import com.example.storehexagonal.infrastructure.persitence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
