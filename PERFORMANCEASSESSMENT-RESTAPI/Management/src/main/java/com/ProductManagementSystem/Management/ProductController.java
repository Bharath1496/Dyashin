package com.ProductManagementSystem.Management;

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

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	private ProductService theProductService;
	
	public ProductController(ProductService thePS)
	{
		theProductService = thePS;
	}
	
	
	@GetMapping("/products")
	public List<Products> findAllProducts()
	{
		return theProductService.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Products findProductByID(@PathVariable int id)
	{
		return theProductService.findById(id);
	}
//	
	@PostMapping("/products")
	public ResponseEntity<Products> add(@RequestHeader (value = "ADMIN", required = false) String authHeader ,
										@RequestBody Products product) {
		Products savedProduct = theProductService.Update(product);
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Products> update(@RequestHeader (value = "ADMIN", required = false) String authHeader , 
											@PathVariable int id , 
											@RequestBody Products product) {
		product.setId(id);
		Products updatedProduct = theProductService.Update(product);
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
