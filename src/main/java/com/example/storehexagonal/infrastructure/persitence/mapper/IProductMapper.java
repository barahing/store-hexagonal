package com.example.storehexagonal.infrastructure.persitence.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.example.storehexagonal.domain.model.Product;
import com.example.storehexagonal.infrastructure.persitence.entity.ProductEntity;
import com.example.storehexagonal.infrastructure.web.dto.ProductRequestDTO;
import com.example.storehexagonal.infrastructure.web.dto.ProductResponseDTO;

@Mapper(componentModel = "spring")
public interface IProductMapper {
    
    // Domain <-> Entity
    Product toDomain(ProductEntity productEntity);
    ProductEntity toEntity(Product product);
    
    // Domain <-> DTO
    Product toDomain(ProductRequestDTO productRequestDTO);
    ProductResponseDTO toResponseDTO(Product product);
    List<ProductResponseDTO> toProductResponseDTOList(List<Product> products);
}
