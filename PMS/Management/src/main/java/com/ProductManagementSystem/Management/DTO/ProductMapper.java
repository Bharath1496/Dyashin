package com.ProductManagementSystem.Management.DTO;

import java.time.LocalTime;

import org.springframework.stereotype.Component;

import com.ProductManagementSystem.Management.entity.Categories;
import com.ProductManagementSystem.Management.entity.Products;

import jakarta.persistence.Column;

@Component
public class ProductMapper {

    // Method to convert Product entity to ProductDTO
    public static ProductDTO toDTO(Products product) {
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getSku(),
            product.getPrice(),
            product.getStock_quantity(),
            product.getCategory_id().getId(),
            product.getCreated_by(),
            product.getUpdated_by(),
            product.getIsDeleted(),
            product.getCreated_at(),
            product.getUpdated_at()
            
        );
    }
    
    
    
    // Method to convert ProductDTO to Product entity (if needed)
    public static Products toEntity(ProductDTO dto ) {
//        return new Products(
//            productDTO.getId(),
//            productDTO.getName(),
//            productDTO.getDescription(),
//            productDTO.getSku(),
//            productDTO.getPrice(),
//            productDTO.getStock_quantity(),
//            productDTO.getCategory_id(),
//            productDTO.getCreated_by(),
//            productDTO.getUpdated_by(),
//            productDTO.getCreated_at(),
//            productDTO.getUpdated_at()
//        );
    	
    	
    	Products product = new Products();
        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setSku(dto.getSku());
        product.setPrice(dto.getPrice());
        product.setStock_quantity(dto.getStock_quantity());

        // Since DTO has only categoryId, you need to fetch the full category entity before saving
        Categories category = new Categories();
        category.setId(dto.getCategory_id());  
        product.setCategory_id(category);

        product.setCreated_by(dto.getCreated_by());
        product.setUpdated_by(dto.getUpdated_by());
        product.setIsDeleted(dto.getIsDeleted());
        product.setCreated_at(dto.getCreated_at());
        product.setUpdated_at(dto.getUpdated_at());
        

        return product;
        
        
    }
}

