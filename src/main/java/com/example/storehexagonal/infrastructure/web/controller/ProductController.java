package com.example.storehexagonal.infrastructure.web.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.storehexagonal.domain.model.Product;
import com.example.storehexagonal.domain.ports.in.IProductUseCase;
import com.example.storehexagonal.infrastructure.persitence.mapper.IProductMapper;
import com.example.storehexagonal.infrastructure.web.dto.ProductRequestDTO;
import com.example.storehexagonal.infrastructure.web.dto.ProductResponseDTO;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("/products")
public class ProductController {

    //private final CategoryService categoryService;
    private final IProductUseCase productService;
    private final IProductMapper productMapper;

    public ProductController (IProductUseCase productService, IProductMapper productMapper){
        this.productService = productService;
        this.productMapper = productMapper;
        //this.categoryService = categoryService;
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        return ResponseEntity.ok(productMapper.toProductResponseDTOList(productService.getAllProducts()));
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> createProduct (@Valid @RequestBody ProductRequestDTO productRequestDTO){
        Product product = productMapper.toDomain(productRequestDTO);
        return ResponseEntity.ok(productMapper.toResponseDTO(productService.createProduct(product)));
    }

}
