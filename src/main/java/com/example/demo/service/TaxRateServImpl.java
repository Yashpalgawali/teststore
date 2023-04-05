package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TaxRates;
import com.example.demo.repository.TaxRateRepo;

@Service("taxrateserv")
public class TaxRateServImpl implements TaxRateService {

	@Autowired
	TaxRateRepo taxrepo;
	
	@Override
	public int saveTaxRates(TaxRates taxrate) {
		// TODO Auto-generated method stub
		return taxrepo.saveTaxRates(taxrate);
	}

	@Override
	public List<TaxRates> getAllTaxRates() {
		// TODO Auto-generated method stub
		return taxrepo.getAllTaxRates();
	}

	@Override
	public TaxRates getTaxRateById(String id) {
		// TODO Auto-generated method stub
		return taxrepo.getTaxRateById(id);
	}

	@Override
	public int updateTaxRateById(TaxRates trate) {
		// TODO Auto-generated method stub
		return taxrepo.updateTaxRateById(trate);
	}

}
