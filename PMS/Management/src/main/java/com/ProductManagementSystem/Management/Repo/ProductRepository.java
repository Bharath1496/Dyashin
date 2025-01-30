package com.ProductManagementSystem.Management.Repo;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductManagementSystem.Management.entity.Products;

public interface ProductRepository extends JpaRepository<Products , Integer> {
	Page<Products> findByCategoryId(Integer categoryId, Pageable pageable);
}


