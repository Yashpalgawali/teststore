package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.TaxRates;

public interface TaxRateRepo {

	
	public int saveTaxRates(TaxRates taxrate);
	
	public List<TaxRates> getAllTaxRates();
	
	public TaxRates getTaxRateById(String id);
	
	public int updateTaxRateById(TaxRates trate);
	
}
