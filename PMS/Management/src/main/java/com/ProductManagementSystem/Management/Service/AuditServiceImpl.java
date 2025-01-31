package com.ProductManagementSystem.Management.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProductManagementSystem.Management.DTO.ProductDTO;
import com.ProductManagementSystem.Management.Repo.AuditRepository;
import com.ProductManagementSystem.Management.Repo.ProductRepository;
import com.ProductManagementSystem.Management.entity.AuditLog;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AuditServiceImpl implements AuditService{
	
	private AuditRepository auditRepo; // Inject the repository for audit logs

	@Autowired
	public AuditServiceImpl(AuditRepository AR) {
		auditRepo = AR;
	}

	@Override
    public void createAuditLog(ProductDTO product , String action) {
        
		try {
		// Create an audit log entry
        AuditLog auditLog = new AuditLog();
        auditLog.setEntityType("Product");
        auditLog.setEntityId(product.getId());
        auditLog.setAction(action);
        
        
     // Create a map to represent the changes in JSON format
        Map<String, Object> changesMap = new HashMap<>();
        changesMap.put("name", product.getName());
        changesMap.put("sku", product.getSku());
        changesMap.put("price", product.getPrice());
        changesMap.put("stock_quantity", product.getStock_quantity());
        changesMap.put("category_id", product.getCategory_id());
        changesMap.put("description", product.getDescription());
//        
//        // Use ObjectMapper to convert the changesMap to a JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String changesJson = objectMapper.writeValueAsString(changesMap);
//
//        // Set the changes as the JSON string
        auditLog.setChanges(changesJson);
        
//        auditLog.setChanges("changed");
        auditLog.setPerformedBy(product.getCreated_by());
        auditLog.setPerformedAt(LocalDateTime.now());

        // Save the audit log entry
        auditRepo.save(auditLog);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
	
	
}
