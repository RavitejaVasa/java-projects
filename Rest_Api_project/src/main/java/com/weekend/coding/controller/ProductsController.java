package com.weekend.coding.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.weekend.coding.entity.Product;
import com.weekend.coding.pojo.SearchProductApiData;
import com.weekend.coding.repository.ProductRepository;

import jakarta.transaction.Transactional;

@RestController
public class ProductsController {
	
	
	@Autowired
	ProductRepository productRepository;
	
	@Transactional
    @PostMapping("/api/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestBody SearchProductApiData apiData) {
    	
    	
    	List<Product> productsList= productRepository.dbsearchProducts(apiData.getSearchText() );
    			
        return new ResponseEntity<List<Product>>(productsList, HttpStatus.OK);
    }
}