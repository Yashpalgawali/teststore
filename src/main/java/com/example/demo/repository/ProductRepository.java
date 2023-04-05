package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductRepository {

public boolean isSaveProduct(Product prod);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(String pid);
	
	public int updateProduct(Product prod);
	
}
