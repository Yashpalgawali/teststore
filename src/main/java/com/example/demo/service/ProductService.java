package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Product;

public interface ProductService {

	
	public boolean isSaveProduct(Product prod);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(String pid);
	
	public int updateProduct(Product prod);
	
	public List<Product> getproductsbyInvoiceId(Long invid);
}
