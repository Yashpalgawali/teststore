package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Temp_invoice;

public interface TempInvoiceRepository {
	
	public int saveTempInvoice(Temp_invoice teinv);
	
	public List<Temp_invoice> getAllTempInvoicesByTempInvoiceId(int temp_inv_id);
	
	public int getMaxTempInvoiceId();
	
	public int updateTempInvoice(Temp_invoice teinv);
	
	public int deleteTempInvoiceByTempId(String tid);

}
