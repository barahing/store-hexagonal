package com.example.storehexagonal.infrastructure.web.dto;

import com.example.storehexagonal.domain.model.Category;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(min=2, max=100, message = "Name must be between 2 and 100 characters")
    private String name;
    @Size(min=20, max=500, message = "Description must be between 20 and 500 characters")
    private String description;
    @DecimalMin(value="0.0", inclusive = false, message = "Value must be at least 0.1")
    private Double price;
    @Min(value=0, message = "Stock must be a positive number")
    private int stock;
    @NotNull(message = "Category is required")
    private Category category;
}

