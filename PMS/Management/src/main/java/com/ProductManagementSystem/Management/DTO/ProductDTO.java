package com.ProductManagementSystem.Management.DTO;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ProductManagementSystem.Management.entity.Categories;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Version;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private int id;
	private String name;
	private String description;
	private String sku;
	private double price;
	private int stock_quantity;
	private int category_id;
	private String created_by;
	private String updated_by;
	private Boolean isDeleted;

//	@Version // This will enable optimistic locking
//	private int version;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime created_at;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime updated_at;
	
	

}
