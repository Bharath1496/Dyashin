package com.ProductManagementSystem.Management;

import java.util.List;

public interface ProductService {
	
	// get all products
	List<Products> findAll();
	// get product by id
	public Products findById(Integer Id);
	//create product , update product 
	public Products Update(Products p);
	// delete product
	public void deleteById(int Id);
}
