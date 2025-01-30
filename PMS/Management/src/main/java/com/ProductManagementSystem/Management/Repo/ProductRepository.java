package com.ProductManagementSystem.Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductManagementSystem.Management.entity.Products;

public interface ProductRepository extends JpaRepository<Products , Integer> {

}


