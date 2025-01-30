package com.ProductManagementSystem.Management.Service;

import java.util.List;

import com.ProductManagementSystem.Management.DTO.ProductDTO;
import com.ProductManagementSystem.Management.entity.Products;

public interface ProductService {
	
	// get all products
	List<ProductDTO> findAll();
	// get product by id
	public ProductDTO findById(Integer Id);
	//create product , update product 
	public ProductDTO Update(ProductDTO p);
	// delete product
	public void deleteById(int Id);
}
