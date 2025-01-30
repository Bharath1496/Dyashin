package com.ProductManagementSystem.Management.DTO;

import com.ProductManagementSystem.Management.entity.Categories;

public class CategoriesMapper {
	// Convert Entity to DTO
    public static CategoriesDTO toDTO(Categories categories) {
        return new CategoriesDTO(
            categories.getId(),
            categories.getName(),
            categories.getDescription()
        );
    }

    // Convert DTO to Entity
    public static Categories toEntity(CategoriesDTO categoriesDTO) {
        Categories categories = new Categories();
        categories.setId(categoriesDTO.getId());
        categories.setName(categoriesDTO.getName());
        categories.setDescription(categoriesDTO.getDescription());
        return categories;
    }
}
