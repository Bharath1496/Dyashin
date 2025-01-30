package com.ProductManagementSystem.Management.DTO;

import java.time.LocalDateTime;
import java.time.LocalTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogDTO {
	
	private int id;
	
    private String entityType; 
	
    private int entityId;
	
    private String action;
	
    private String changes;
	
    private String performedBy; 
    
    private LocalDateTime performedAt;

}







	