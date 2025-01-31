package com.ProductManagementSystem.Management.Service;

import java.util.ArrayList;
import java.util.List;

import com.ProductManagementSystem.Management.DTO.ProductDTO;
import com.ProductManagementSystem.Management.DTO.ProductMapper;
import com.ProductManagementSystem.Management.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

public interface ProductService {
	
	// get all products
	List<ProductDTO> findAll();
	// get product by id
//	public ProductDTO findById(Integer Id);
	//create product , update product 
	public ProductDTO Update(ProductDTO p);
	// delete product
	public void deleteById(int Id);
	
	public boolean isSkuExists(String sku);
	
//	public List<ProductDTO> mapToProductDTOList(List<Products> products); 
	
	Page<ProductDTO> findAll(Pageable pageable);
	
//	Page<ProductDTO> findAllByCategory(Integer categoryId, Pageable pageable);
	
	public ProductDTO checkIfProductExists(int id);
	
	public Page<ProductDTO> findByName(String name, Pageable pageable);
	
	 public Page<ProductDTO> findBySku(String sku, Pageable pageable);
	     
//	 public Page<ProductDTO> findByCategory(Integer categoryId, Pageable pageable);

//	Page<Products> productPage = theProductService.findAll(pageable);
}
