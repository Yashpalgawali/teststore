package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Temp_invoice;

public interface TempInvoiceService {

	public int saveTempInvoice(Temp_invoice teinv);
	
	public List<Temp_invoice> getAllTempInvoicesByTempInvoiceId(int temp_inv_id);
	
	public int updateTempInvoice(Temp_invoice teinv);
	
	public int getMaxTempInvoiceId();

	public int deleteTempInvoiceByTempId(String tid);

}

