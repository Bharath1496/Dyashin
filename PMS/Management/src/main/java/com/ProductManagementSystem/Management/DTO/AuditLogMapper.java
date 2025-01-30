package com.ProductManagementSystem.Management.DTO;

import com.ProductManagementSystem.Management.entity.AuditLog;

public class AuditLogMapper {
	
	
	
	// Convert Entity to DTO
	public static AuditLogDTO toDTO(AuditLog auditLog) {
        return new AuditLogDTO(
            auditLog.getId(),
            auditLog.getEntityType(),
            auditLog.getEntityId(),
            auditLog.getAction(),
            auditLog.getChanges(),
            auditLog.getPerformedBy(),
            auditLog.getPerformedAt()
        );
    }
            
           

    // Convert DTO to Entity
    public static AuditLog toEntity(AuditLogDTO auditLogDTO) {
        AuditLog auditLog = new AuditLog();
        auditLog.setId(auditLogDTO.getId());
        auditLog.setEntityType(auditLogDTO.getEntityType());
        auditLog.setEntityId(auditLogDTO.getEntityId());
        auditLog.setAction(auditLogDTO.getAction());
        auditLog.setChanges(auditLogDTO.getChanges());
        auditLog.setPerformedBy(auditLogDTO.getPerformedBy());
        auditLog.setPerformedAt(auditLogDTO.getPerformedAt());
        return auditLog;
    }
	
}
