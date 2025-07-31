package com.example.storehexagonal.infrastructure.web.dto;

import com.example.storehexagonal.domain.model.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int stock;
    private Category category;
}
