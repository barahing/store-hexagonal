package com.example.storehexagonal.infrastructure.persitence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.storehexagonal.infrastructure.persitence.entity.ProductEntity;

public interface IJpaProductRepository extends JpaRepository<ProductEntity, Long> {

}
