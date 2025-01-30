package com.ProductManagementSystem.Management.DTO;

import java.time.LocalDateTime;
import java.time.LocalTime;

import com.ProductManagementSystem.Management.entity.Categories;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	    private LocalDateTime created_at;

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	    private LocalDateTime updated_at;
	

}
