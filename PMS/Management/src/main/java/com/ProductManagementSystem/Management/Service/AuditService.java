package com.ProductManagementSystem.Management.Service;


import com.ProductManagementSystem.Management.DTO.ProductDTO;


public interface AuditService {
	
	 public void createAuditLog(ProductDTO product, String action);

}
