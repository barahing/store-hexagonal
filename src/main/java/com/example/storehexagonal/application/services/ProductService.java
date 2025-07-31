package com.example.storehexagonal.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.storehexagonal.domain.model.Product;
import com.example.storehexagonal.domain.ports.in.IProductUseCase;
import com.example.storehexagonal.domain.ports.out.IProductRepositoryPort;

@Service
public class ProductService implements IProductUseCase {
    private final IProductRepositoryPort iProductRepositoryPort;

    public ProductService (IProductRepositoryPort iProductRepositoryPort){
        this.iProductRepositoryPort = iProductRepositoryPort;
    }

    @Override
    public Product createProduct(Product product) {
        return iProductRepositoryPort.save(product);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return iProductRepositoryPort.getById(id);
    }

    @Override
    public List<Product> getAllProducts() {
        return iProductRepositoryPort.getAllProducts();
    }

    @Override
    public void delete(Long id) {
        iProductRepositoryPort.delete(id);
    }

}
