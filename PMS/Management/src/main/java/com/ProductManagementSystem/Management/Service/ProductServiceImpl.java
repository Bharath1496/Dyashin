package com.ProductManagementSystem.Management.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductManagementSystem.Management.DTO.ProductDTO;
import com.ProductManagementSystem.Management.DTO.ProductMapper;
import com.ProductManagementSystem.Management.Repo.ProductRepository;
import com.ProductManagementSystem.Management.entity.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductRepository ProductRepo;

	@Autowired
	public ProductServiceImpl(ProductRepository PR) {
		ProductRepo = PR;
	}

	@Override
	public List<ProductDTO> findAll() {
		
		List<Products> pList = ProductRepo.findAll();
		
		List<ProductDTO> Pd = new ArrayList<>();
		
		for(Products p : pList)
		{
			ProductDTO Pdto = ProductMapper.toDTO(p);
			Pd.add(Pdto);
		}
		return Pd;
	
	}
	
//	@Override
//	public Page<ProductDTO> findByName(Pageable pageable) {
//	    Optional<Products> result = ProductRepo.findById(pageable);
//	    
//	    Page<Products> productPage = ProductRepo.findById(pageable);
//	    
//	    List<ProductDTO> productDtos = new ArrayList<>();
//
//	    for (Products product : productPage.getContent()) 
//	    {
//	        productDtos.add(ProductMapper.toDTO(product));
//	    }
//	    
//	    return new PageImpl<>(productDtos, pageable, productPage.getTotalElements());
		
		@Override
		public Page<ProductDTO> findByName(String name, Pageable pageable) {
		    Page<Products> productPage = ProductRepo.findByNameContainingIgnoreCase(name, pageable);

		    List<ProductDTO> productDtos = new ArrayList<>();
		    for (Products product : productPage.getContent()) {
		        productDtos.add(ProductMapper.toDTO(product));
		    }

		    return new PageImpl<>(productDtos, pageable, productPage.getTotalElements());
		}

//	}
		
	
	


	@Override
	@Transactional
	public ProductDTO Update(ProductDTO e) { 
		
		if (e.getName() == null || e.getName().isEmpty()) {
	        throw new IllegalArgumentException("Product name is required");
	    }
	    
	    if (e.getSku() == null || e.getSku().isEmpty()) {
	        throw new IllegalArgumentException("SKU is required");
	    }
	    
	    if (e.getPrice() <= 0) {
	        throw new IllegalArgumentException("Price must be greater than 0");
	    }
	    
	    if (e.getStock_quantity() < 0) {
	        throw new IllegalArgumentException("Stock quantity cannot be negative");
	    }
	    
	    Products existingProduct = ProductRepo.findById(e.getId()).orElse(null);
	    
	    ProductDTO pdto = ProductMapper.toDTO(existingProduct);

	    if (pdto == null) 
	    {
	        throw new RuntimeException("Product not found");
	    }
	    
//	    if (pdto.getVersion() != e.getVersion()) {
//	        throw new RuntimeException("Product has been modified by another user. Please reload and try again.");
//	    }
	    
		Products p = ProductMapper.toEntity(pdto);
		ProductRepo.save(p);
		ProductDTO pdtoTwo = ProductMapper.toDTO(p);
		return pdtoTwo;
	}

	@Override
	@Transactional
	public void deleteById(int id) 
	{

	    Optional<Products> product = ProductRepo.findById(id);
	    
	    // Check if the product exists and is not already deleted
	    if (product == null || product.get().getIsDeleted()) {
	        throw new RuntimeException("Product not found or already deleted");
	    }
	    
	    // 1. Soft delete: Set the product as deleted
	    product.get().setIsDeleted(true); 
	    
	    Products p = product.get();
	    // 2. Save the updated product with soft delete
	    ProductRepo.save(p);
	}
	
	 @Override
	 public boolean isSkuExists(String sku) 
	 {
	        
	        List<Products> products = ProductRepo.findAll(); 
	        for (Products product : products) 
	        {
	            if (product.getSku().equals(sku)) 
	            {
	                return true;  // SKU exists
	            }
	        }
	        return false;  // SKU doesn't exist
	    }
	 
//	 @Override
//	 public List<ProductDTO> mapToProductDTOList(List<Products> products) {
//		    List<ProductDTO> productDtos = new ArrayList<>();
//		    for (Products product : products) {
//		        ProductDTO productDto = ProductMapper.toDTO(product);  // Assuming this method exists
//		        productDtos.add(productDto);
//		    }
//		    return productDtos;
//		}
	 
	 @Override
	    public Page<ProductDTO> findAll(Pageable pageable) {

		    Page<Products> productPage = ProductRepo.findAll(pageable);
		    
		    List<ProductDTO> productDtos = new ArrayList<>();
		    
		    for (Products product : productPage.getContent()) 
		    {
		        productDtos.add(ProductMapper.toDTO(product));
		    }

		    return new PageImpl<>(productDtos, pageable, productPage.getTotalElements());
	    }
	 
	 @Override
	 public Page<ProductDTO> findAllByCategory(Integer categoryId, Pageable pageable) {
	     
		 Page<Products> productPage = ProductRepo.findByCategoryId(categoryId, pageable);
	     
	     List<ProductDTO> productDtos = new ArrayList<>();
		    
	     for (Products product : productPage.getContent()) 
		    {
		        productDtos.add(ProductMapper.toDTO(product));
		    }

		    return new PageImpl<>(productDtos, pageable, productPage.getTotalElements());
		    
//	     return productPage.map(ProductMapper::toDTO);
	     
	 }
	 
	 @Override
	 public ProductDTO checkIfProductExists(int id) {
		 
		 Optional<Products> result = ProductRepo.findById(id);

		    if (result.isPresent()) {
		        return ProductMapper.toDTO(result.get()); // Convert entity to DTO
		    } else {
		        throw new RuntimeException("Product not found with ID: " + id);
		    }
		    
		}
	 
	 
//	 @Override
//	 public Page<ProductDTO> findByName(String name, Pageable pageable) {
//	     Page<Products> productPage = ProductRepo.findByNameContainingIgnoreCase(name, pageable);
//	     
//	     List<ProductDTO> productDtos = new ArrayList<>();
//	     for (Products product : productPage.getContent()) {
//	         productDtos.add(ProductMapper.toDTO(product));
//	     }
//	     return new PageImpl<>(productDtos, pageable, productPage.getTotalElements());
////	     return convertToProductDTOPage(productPage, pageable);
//	 }

	 @Override
	 public Page<ProductDTO> findBySku(String sku, Pageable pageable) {
	     Page<Products> productPage = ProductRepo.findBySkuContainingIgnoreCase(sku, pageable);
	     
	     List<ProductDTO> productDtos = new ArrayList<>();
	     for (Products product : productPage.getContent()) {
	         productDtos.add(ProductMapper.toDTO(product));
	     }
	     return new PageImpl<>(productDtos, pageable, productPage.getTotalElements());
	     
//	     return convertToProductDTOPage(productPage, pageable);
	 }

	 @Override
	 public Page<ProductDTO> findByCategory(Integer categoryId, Pageable pageable) {
	     Page<Products> productPage = ProductRepo.findByCategoryId(categoryId, pageable);
	     List<ProductDTO> productDtos = new ArrayList<>();
	     for (Products product : productPage.getContent()) {
	         productDtos.add(ProductMapper.toDTO(product));
	     }
	     return new PageImpl<>(productDtos, pageable, productPage.getTotalElements());
//	     return convertToProductDTOPage(productPage, pageable);
	 }

	 // Utility method for converting entity pages to DTO pages
//	 private Page<ProductDTO> convertToProductDTOPage(Page<Products> productPage, Pageable pageable) {
//	     List<ProductDTO> productDtos = new ArrayList<>();
//	     for (Products product : productPage.getContent()) {
//	         productDtos.add(ProductMapper.toDTO(product));
//	     }
//	     return new PageImpl<>(productDtos, pageable, productPage.getTotalElements());
//	 }


	 
	
}
