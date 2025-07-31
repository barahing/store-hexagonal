package com.example.storehexagonal.domain.ports.out;

import java.util.List;
import java.util.Optional;

import com.example.storehexagonal.domain.model.Product;

public interface IProductRepositoryPort {
    Product save(Product product);
    Optional<Product> getById (Long id);
    List<Product> getAllProducts();
    void delete (Long id);
}
