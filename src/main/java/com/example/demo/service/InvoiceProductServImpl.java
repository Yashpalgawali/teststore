package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice_Product;
import com.example.demo.repository.InvoiceProductRepository;

@Service("invprodserv")
public class InvoiceProductServImpl implements InvoiceProductService {
	
	@Autowired
	InvoiceProductRepository invprodrepo;
	
	@Override
	public int saveInvoiceProduct(Invoice_Product invprod) {
		// TODO Auto-generated method stub
		return invprodrepo.saveInvoiceProduct(invprod);
	}

	@Override
	public List<Invoice_Product> getInvoiceProdListByOrderId(String Order_id) {
		// TODO Auto-generated method stub
		return invprodrepo.getInvoiceProdListByOrderId(Order_id);
	}

}
