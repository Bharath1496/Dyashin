package com.ProductManagementSystem.Management.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ProductManagementSystem.Management.DTO.ProductDTO;
import com.ProductManagementSystem.Management.Service.ProductService;
import com.ProductManagementSystem.Management.entity.Products;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	private ProductService theProductService;
	
	public ProductController(ProductService thePS)
	{
		theProductService = thePS;
	}
	
	@GetMapping("/products")
	public List<ProductDTO> findAllProducts()
	{
		return theProductService.findAll();
	}
	
	@GetMapping("/products/{id}")
	public ProductDTO findProductByID(@PathVariable int id)
	{
		return theProductService.findById(id);
	}
	
	@PostMapping("/products")
	public ResponseEntity<ProductDTO> add(@RequestHeader (value = "ADMIN", required = false) String authHeader ,
										@RequestBody ProductDTO productDto) {
		ProductDTO savedProduct = theProductService.Update(productDto);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<ProductDTO> update(@RequestHeader (value = "ADMIN", required = false) String authHeader , 
											@PathVariable int id , 
											@RequestBody ProductDTO productDto) {
		productDto.setId(id);
		ProductDTO updatedProduct = theProductService.Update(productDto);
	    return ResponseEntity.ok(updatedProduct);
	}
	
	@DeleteMapping("/products/{id}")
	public String delete(@PathVariable int id , 
			@RequestHeader (value = "ADMIN", required = true) String authHeader)
	{
		theProductService.deleteById(id);
		return "Product " + id + "deleted";
	}
	

}
