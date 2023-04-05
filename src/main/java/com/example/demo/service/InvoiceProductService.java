package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Invoice_Product;

public interface InvoiceProductService {

	public int saveInvoiceProduct(Invoice_Product invprod);
	
	public List<Invoice_Product> getInvoiceProdListByOrderId(String order_id);
	
	
}