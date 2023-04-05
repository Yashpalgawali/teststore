package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Invoice_Product;

public interface InvoiceProductRepository {
	
	public int saveInvoiceProduct(Invoice_Product prod);
	
	public List<Invoice_Product> getInvoiceProdListByOrderId(String order_id);

}
