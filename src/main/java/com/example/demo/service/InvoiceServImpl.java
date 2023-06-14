package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;

@Service("invserv")
public class InvoiceServImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invrepo;
	
	@Override
	public int saveInvoice(Invoice inv) {
		// TODO Auto-generated method stub
		return invrepo.saveInvoice(inv);
	}

	@Override
	public Integer getMaxInvoiceNumber() {
		// TODO Auto-generated method stub
		return invrepo.getMaxInvoiceNumber();
	}

	@Override
	public List<Invoice> getAllInvoices() {
		// TODO Auto-generated method stub
		List<Invoice> invlist = invrepo.getAllInvoices();
		
		System.err.println("\n Inside getallinvoice service\n");
		
		for(int i=0;i<invlist.size();i++)
		{
			System.err.println(invlist.get(i));
		}
		//invlist.stream().forEach(e->System.err.println(e));
		return invlist;
	}

	@Override
	public Invoice getInvoiceByInvoiceId(String id) {
		// TODO Auto-generated method stub
		return invrepo.getInvoiceByInvoiceId(id);
	}

	@Override
	public  List<Invoice>  viewInvoiceByIdToPrint(String invid) {
		// TODO Auto-generated method stub
		return invrepo.viewInvoiceByIdToPrint(invid);
	}

}
