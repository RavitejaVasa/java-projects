package com.weekend.coding.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.weekend.coding.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Procedure(procedureName = "product_detals_search")
	
	List<Product> dbsearchProducts(@Param("search_text") String searchText);
	
}
