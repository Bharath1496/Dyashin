package com.ProductManagementSystem.Management.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ProductManagementSystem.Management.entity.AuditLog;

public interface AuditRepository extends JpaRepository<AuditLog, Integer>{

}
