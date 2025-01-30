package com.ProductManagementSystem.Management.entity;

import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="audit_logs")
public class AuditLog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="entity_type")
    private String entityType; 
	
	@Column(name="entity_id")
    private int entityId;
	
	@Column(name="action")
    private String action;
	
	@Column(name="changes")
    private String changes;
	
	@Column(name="performed_by")
    private String performedBy; 
    
	@Column(name="performed_at")
    private LocalTime performedAt;

	@Override
	public String toString() {
		return "AuditLog [id=" + id + ", entityType=" + entityType + ", entityId=" + entityId + ", action=" + action
				+ ", changes=" + changes + ", performedBy=" + performedBy + ", performed_at=" + performedAt + "]";
	}
	
}
