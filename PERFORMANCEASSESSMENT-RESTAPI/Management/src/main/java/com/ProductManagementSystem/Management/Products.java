package com.ProductManagementSystem.Management;

import java.sql.Timestamp;
import java.time.LocalTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

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
    
	@Column(name="category_id")
    private int category_id;
	
	@Column(name="created_by")
    private String created_by;
	
	@Column(name="updated_by")
    private String updated_by;
	
	@Column(name="created_at")
	//@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private Timestamp created_at;
	
	@Column(name="updated_at")
	//@JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private Timestamp updated_at;

	public Products(int id, String name, String description, String sku, double price, int stock_quantity,
			int category_id, String created_by, String updated_by, Timestamp created_at, Timestamp updated_at) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.sku = sku;
		this.price = price;
		this.stock_quantity = stock_quantity;
		this.category_id = category_id;
		this.created_by = created_by;
		this.updated_by = updated_by;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	public Products() {
		super();
	}

	public int getId() {
		return id;
	}

	public  void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock_quantity() {
		return stock_quantity;
	}

	public void setStock_quantity(int stock_quantity) {
		this.stock_quantity = stock_quantity;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", description=" + description + ", sku=" + sku + ", price="
				+ price + ", stock_quantity=" + stock_quantity + ", category_id=" + category_id + ", created_by="
				+ created_by + ", updated_by=" + updated_by + ", created_at=" + created_at + ", updated_at="
				+ updated_at + "]";
	}
    

     
	
}
