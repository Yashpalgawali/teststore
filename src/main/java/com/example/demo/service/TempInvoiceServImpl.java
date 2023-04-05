package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Temp_invoice;
import com.example.demo.repository.TempInvoiceRepository;

@Service("tempinvserv")
public class TempInvoiceServImpl implements TempInvoiceService {

	@Autowired
	TempInvoiceRepository tempinvrepo;

	@Override
	public int saveTempInvoice(Temp_invoice teinv) {
		// TODO Auto-generated method stub
		return tempinvrepo.saveTempInvoice(teinv);
	}

	@Override
	public List<Temp_invoice> getAllTempInvoicesByTempInvoiceId(int temp_inv_id) {
		// TODO Auto-generated method stub
		return tempinvrepo.getAllTempInvoicesByTempInvoiceId(temp_inv_id);
	}

	@Override
	public int updateTempInvoice(Temp_invoice teinv) {
		// TODO Auto-generated method stub
		return tempinvrepo.updateTempInvoice(teinv);
	}

	@Override
	public int getMaxTempInvoiceId() {
		// TODO Auto-generated method stub
		return tempinvrepo.getMaxTempInvoiceId();
	}

	@Override
	public int deleteTempInvoiceByTempId(String tid) {
		// TODO Auto-generated method stub
		return tempinvrepo.deleteTempInvoiceByTempId(tid);
	}

}
