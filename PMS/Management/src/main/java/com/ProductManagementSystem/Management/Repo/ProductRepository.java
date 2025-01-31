package com.ProductManagementSystem.Management.Repo;

//import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductManagementSystem.Management.entity.Categories;
import com.ProductManagementSystem.Management.entity.Products;

public interface ProductRepository extends JpaRepository<Products , Integer> {
	
//	Page<Products> findByCategoryId(Integer categoryId, Pageable pageable);
	
	// Custom query method to find products by name with pagination
    Page<Products> findByNameContainingIgnoreCase(String name, Pageable pageable);
    
    // Search by SKU (Case-Insensitive) with Pagination
    Page<Products> findBySkuContainingIgnoreCase(String sku, Pageable pageable);

    // Search by Category with Pagination
//    Page<Products> findByCategoryId(Integer category_Id, Pageable pageable);
    
//    Page<Products> findByCategoryId(Categories category, Pageable pageable);

    
}




