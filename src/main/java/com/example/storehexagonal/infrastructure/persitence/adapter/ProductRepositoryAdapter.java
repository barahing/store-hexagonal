package com.example.storehexagonal.infrastructure.persitence.adapter;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.storehexagonal.domain.model.Product;
import com.example.storehexagonal.domain.ports.out.IProductRepositoryPort;
import com.example.storehexagonal.infrastructure.persitence.entity.ProductEntity;
import com.example.storehexagonal.infrastructure.persitence.jpa.IJpaProductRepository;
import com.example.storehexagonal.infrastructure.persitence.mapper.IProductMapper;

@Repository
public class ProductRepositoryAdapter implements IProductRepositoryPort{
    private final IJpaProductRepository jpaProductRepository;
    private final IProductMapper productMapper;

    public ProductRepositoryAdapter (IJpaProductRepository jpaProductRepository, IProductMapper productMapper){
        this.jpaProductRepository = jpaProductRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = productMapper.toEntity(product);
        return productMapper.toDomain(jpaProductRepository.save(productEntity));
    }

    @Override
    public Optional<Product> getById(Long id) {
        ProductEntity productEntity = jpaProductRepository.findById(id).orElseThrow(
            ()->new RuntimeException("Product not found")
        );
        return Optional.of(productMapper.toDomain(productEntity));
    }

    @Override
    public List<Product> getAllProducts() {
        return jpaProductRepository.findAll().stream()
            .map(productMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        jpaProductRepository.deleteById(id);
    }
    
}
