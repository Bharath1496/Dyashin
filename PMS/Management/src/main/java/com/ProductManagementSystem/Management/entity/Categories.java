package com.ProductManagementSystem.Management.entity;

import java.time.LocalTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="categories")
public class Categories {

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name="id")
		private int id;
		
		@Column(name="name")
	    private String name; 
		
		@Column(name="description")
	    private String description;

		@Override
		public String toString() {
			return "Categories [id=" + id + ", name=" + name + ", description=" + description + "]";
		}
		
		@OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
	    private List<Products> products;

}
