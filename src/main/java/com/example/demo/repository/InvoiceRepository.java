package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Invoice;

public interface InvoiceRepository {

	
	public int saveInvoice(Invoice inv);
	
	public Integer getMaxInvoiceNumber();
	
	public List<Invoice> getAllInvoices();
	
	public Invoice getInvoiceByInvoiceId(String id);
	
	public  List<Invoice>  viewInvoiceByIdToPrint(String invid); 
	
	
}