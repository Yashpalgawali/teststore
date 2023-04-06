package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service("prodserv")
public class ProductServImpl implements ProductService {

	@Autowired
	ProductRepository prodrepo;
	
	@Override
	public boolean isSaveProduct(Product prod) {
		// TODO Auto-generated method stub
		return prodrepo.isSaveProduct(prod);
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return prodrepo.getAllProducts();
	}

	@Override
	public Product getProductById(String pid) {
		// TODO Auto-generated method stub
		return prodrepo.getProductById(pid);
	}

	@Override
	public int updateProduct(Product prod) {
		// TODO Auto-generated method stub
		
		float cgst_per = prod.getGsttax()/2;
		float sgst_per = prod.getGsttax()/2;
		float igst_per = prod.getGsttax();
		
		prod.setCgst_per(cgst_per);
		prod.setSgst_per(sgst_per);
		prod.setIgst_per(igst_per);
		
		return prodrepo.updateProduct(prod);
	}

}
