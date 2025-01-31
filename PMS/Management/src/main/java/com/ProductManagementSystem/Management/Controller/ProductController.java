package com.ProductManagementSystem.Management.Controller;

//import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ProductManagementSystem.Management.DTO.ProductDTO;
import com.ProductManagementSystem.Management.DTO.ProductMapper;
import com.ProductManagementSystem.Management.Service.AuditService;
import com.ProductManagementSystem.Management.Service.ProductService;
import com.ProductManagementSystem.Management.entity.Products;
import org.springframework.data.domain.Sort;


import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.ResponseEntity;


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
	
	@PostMapping("/products")
	public ResponseEntity<ProductDTO> add(@RequestHeader (value = "ADMIN", required = false) String authHeader ,
										@RequestBody ProductDTO productDto) 
	{
		
		 // 1. Validation for required fields
	    if (productDto.getName() == null || productDto.getSku() == null || productDto.getPrice() <= 0) 
	    {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	    }
		
	    // 2. Check for duplicate SKU
	    if (theProductService.isSkuExists(productDto.getSku())) 
	    {
	        return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
	    }
	    
	    // 3. Set timestamps and user
	    productDto.setCreated_at(LocalDateTime.now());
	    productDto.setCreated_by(authHeader != null ? authHeader : "defaultUser");
	    productDto.setIsDeleted(false);
	    
	    // 4. Save the product and return
	    ProductDTO savedProduct = theProductService.Update(productDto);

	    // 5. Log the action
	    //Should create an audit log entry
	    theAuditService.createAuditLog(savedProduct , "CREATE");
		
	    return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
	}

	@GetMapping("/products")
	public ResponseEntity<Map<String, Object>> findAllProducts(
        @RequestParam(value = "page", defaultValue = "0") int page, 
        @RequestParam(value = "size", defaultValue = "10") int size,
        @RequestParam(value = "sortBy", defaultValue = "id") String sortBy, 
        @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir, 
        @RequestParam(value = "category", required = false) Integer categoryId) 
	{
		// Create the Pageable object with sorting and pagination
		Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortBy);
		    
//		    Page<ProductDTO> productPage = theProductService.findAll(pageable);
		    
		// Fetch products with optional category filtering
		Page<ProductDTO> productPage;
		
//		if (categoryId != null) - this
//		{
//		   productPage = theProductService.findAllByCategory(categoryId, pageable); 
//		} 
//		else 
//		{
		   productPage = theProductService.findAll(pageable);
//		}
		    
		// Prepare response data
		Map<String, Object> response = new HashMap<>();
		response.put("products", productPage.getContent()); // List of products
		response.put("currentPage", productPage.getNumber());
		response.put("totalItems", productPage.getTotalElements());
		response.put("totalPages", productPage.getTotalPages());
		response.put("pageSize", productPage.getSize());
		response.put("isLastPage", productPage.isLast());
		    
		return ResponseEntity.ok(response);
		    
	}
	
		@PutMapping("/products/{id}")
		public ResponseEntity<ProductDTO> update(
				@RequestHeader (value = "ADMIN", required = true) String authHeader , 
				@PathVariable(value = "id") int id , 
				@RequestBody ProductDTO productDto) 
		{
			// 1. Check if the product exists
		    ProductDTO existingProduct = theProductService.checkIfProductExists(id);
		    ProductDTO updatedProduct; 
		    if(existingProduct !=null)
		    {
		    	// 2. Update product fields
			    productDto.setId(id);
			    productDto.setIsDeleted(false);
				updatedProduct = theProductService.Update(productDto);
		    }
		    else
		    {
		    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		    }
		    

		    //Should create an audit log entry
		    theAuditService.createAuditLog(updatedProduct, "UPDATE");
		    
		    return ResponseEntity.ok(updatedProduct);
		    
		}
		
		
		@DeleteMapping("/products/{id}")
		public ResponseEntity<ProductDTO> delete(
				@PathVariable(value = "id") int id  , 
				@RequestHeader (value = "ADMIN", required = true) String authHeader)
		{
			
			// 1. Check if the product exists
		    ProductDTO existingProduct = theProductService.checkIfProductExists(id);
		    		    
			theProductService.deleteById(id);

		    // 3. Create an audit log entry with action "DELETE"
		    theAuditService.createAuditLog(existingProduct, "DELETE");

		    // 4. Return success response
		    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		    
		}
	
	
//		@GetMapping("/products/{id}")
//		public ProductDTO findProductByID(@PathVariable int id)
//		{
//			return theProductService.findById(id);
//		}
		
		@GetMapping("/products/search")
		public ResponseEntity<Map<String, Object>> searchProducts(
		        @RequestParam(value = "name", required = false) String name,
		        @RequestParam(value = "sku", required = false) String sku,
		        @RequestParam(value = "category", required = false) Integer categoryId,
		        @RequestParam(value = "minPrice", required = false) Double minPrice,
		        @RequestParam(value = "maxPrice", required = false) Double maxPrice,
		        @RequestParam(value = "page", defaultValue = "0") int page,
		        @RequestParam(value = "size", defaultValue = "10") int size,
		        @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
		        @RequestParam(value = "sortDir", defaultValue = "asc") String sortDir) 
		{
		    
		    // Create the Pageable object with sorting and pagination
		    Pageable pageable = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sortBy);
		    
		    // Fetch paginated and sorted results from the service
//		    Page<ProductDTO> productPage = theProductService.findById(pageable);
//		    Page<ProductDTO> productPage = theProductService.findByName(name, pageable);
		    Page<ProductDTO> productPage;

		    // Determine search criteria
		    if (name != null && !name.isEmpty()) 
		    {
		        productPage = theProductService.findByName(name, pageable);
		    } 
		    else if (sku != null && !sku.isEmpty()) 
		    {
		        productPage = theProductService.findBySku(sku, pageable);
		    } 
//		    else if (categoryId != null) - this
//		    {
//		        productPage = theProductService.findByCategory(categoryId, pageable);
//		    } 
		    else 
		    {
		        // If no valid parameter is provided, return a bad request response
		        Map<String, String> errorResponse = new HashMap<>();
		        errorResponse.put("error", "Please provide at least one search criteria: name, sku, or category.");
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", errorResponse));
		    }
		    // Prepare response data
		    Map<String, Object> response = new HashMap<>();
		    response.put("products", productPage.getContent()); // List of products
		    response.put("currentPage", productPage.getNumber());
		    response.put("totalItems", productPage.getTotalElements());
		    response.put("totalPages", productPage.getTotalPages());
		    response.put("pageSize", productPage.getSize());
		    response.put("isLastPage", productPage.isLast());
		    
		    return ResponseEntity.ok(response);
		}		
		
		
	
}
