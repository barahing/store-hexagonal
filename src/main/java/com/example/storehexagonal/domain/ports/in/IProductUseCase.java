package com.example.storehexagonal.domain.ports.in;

import java.util.List;
import java.util.Optional;

import com.example.storehexagonal.domain.model.Product;

public interface IProductUseCase {
    Product createProduct(Product product);
    Optional<Product> getById (Long id);
    List<Product> getAllProducts();
    void delete (Long id);
    /*Product raiseStock (Long id, int quantity);
    Product withdrawStock (Long id, int quantity);*/
}
