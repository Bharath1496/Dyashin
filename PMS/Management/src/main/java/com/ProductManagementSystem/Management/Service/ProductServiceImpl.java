package com.ProductManagementSystem.Management.Service;

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
	
	@Override
	public ProductDTO findById(Integer id) {
	    Optional<Products> result = ProductRepo.findById(id);

	    if (result.isPresent()) {
	        return ProductMapper.toDTO(result.get()); // Convert entity to DTO
	    } else {
	        throw new RuntimeException("Product not found with ID: " + id);
	    }
	}


	@Override
	@Transactional
	public ProductDTO Update(ProductDTO e) { 
		Products p = ProductMapper.toEntity(e);
		ProductRepo.save(p);
		ProductDTO pdto = ProductMapper.toDTO(p);
		return pdto;
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		ProductRepo.deleteById(id);
	}
	
	 @Override
	 public boolean isSkuExists(String sku) {
	        
	        List<Products> products = ProductRepo.findAll(); 
	        for (Products product : products) {
	            if (product.getSku().equals(sku)) {
	                return true;  // SKU exists
	            }
	        }
	        return false;  // SKU doesn't exist
	    }

}
