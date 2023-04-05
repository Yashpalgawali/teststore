package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Invoice;

public interface InvoiceService {

	public int saveInvoice(Invoice inv);
	
	public Integer getMaxInvoiceNumber();
	
	public List<Invoice> getAllInvoices();
	
	public Invoice getInvoiceByInvoiceId(String id);
	
	public  List<Invoice>  viewInvoiceByIdToPrint(String invid) ;
	
}
