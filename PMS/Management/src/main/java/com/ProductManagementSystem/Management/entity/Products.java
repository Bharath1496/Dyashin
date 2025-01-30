package com.ProductManagementSystem.Management.entity;

import java.time.LocalDateTime;
//import java.sql.Timestamp;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="products")
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
    private String name; 
	
	@Column(name="description")
    private String description;
	
	@Column(name="sku")
    private String sku;
	
	@Column(name="price")
    private double price;
	
	@Column(name="stock_quantity")
    private int stock_quantity; 
    
	@ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Categories category_id;
	
	@Column(name="created_by")
    private String created_by;
	
	@Column(name="updated_by")
    private String updated_by;
	
	@Column(name="created_at")
//	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime created_at;
	
	@Column(name="updated_at")
//	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updated_at;
	
	

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", description=" + description + ", sku=" + sku + ", price="
				+ price + ", stock_quantity=" + stock_quantity + ", category_id=" + category_id + ", created_by="
				+ created_by + ", updated_by=" + updated_by + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}
    
}
