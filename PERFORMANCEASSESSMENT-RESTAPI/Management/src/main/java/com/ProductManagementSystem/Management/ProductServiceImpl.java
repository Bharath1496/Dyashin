package com.ProductManagementSystem.Management;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService{
	
	private ProductRepository ProductRepo;
	
	@Autowired
	public ProductServiceImpl(ProductRepository PR)
	{
		ProductRepo = PR;
	}
	
	
	@Override
	public List<Products> findAll()
	{
		return ProductRepo.findAll();
	}

	@Override
	public Products findById(Integer Id) {
		Optional<Products> result = ProductRepo.findById(Id);
		Products theProducts = result.get();
		return theProducts;
	}

	@Override
	@Transactional
	public Products Update(Products e) {
		return ProductRepo.save(e);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		ProductRepo.deleteById(id);
	}
	
	
}
