package com.ProductManagementSystem.Management.Controller;

import java.time.LocalDateTime;
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
import com.ProductManagementSystem.Management.Service.AuditService;
import com.ProductManagementSystem.Management.Service.ProductService;
import com.ProductManagementSystem.Management.entity.Products;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	private ProductService theProductService;
	
	private AuditService theAuditService;
	
	public ProductController(ProductService thePS , AuditService theAS)
	{
		theProductService = thePS;
		theAuditService = theAS;
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
		
		 // 1. Validation for required fields
	    if (productDto.getName() == null || productDto.getSku() == null || productDto.getPrice() <= 0) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    }
		
	    // 2. Check for duplicate SKU
	    if (theProductService.isSkuExists(productDto.getSku())) {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
	    }
	    
	    // 3. Set timestamps and user
	    productDto.setCreated_at(LocalDateTime.now());
	    productDto.setCreated_by(authHeader != null ? authHeader : "defaultUser");
	    
	    // 4. Save the product and return
	    ProductDTO savedProduct = theProductService.Update(productDto);

	    // 5. Log the action
//	    Should create an audit log entry
	    theAuditService.createAuditLog(savedProduct);
		
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
