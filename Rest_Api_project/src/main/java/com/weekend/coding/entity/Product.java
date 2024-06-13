package com.weekend.coding.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Product {
	
	
	@Id
	public int product_id;
	public String title;
	public String discreption;
	public float price;
	public String thumbnail_path;
	public int no_of_reviews;
	public int in_stock;

}

