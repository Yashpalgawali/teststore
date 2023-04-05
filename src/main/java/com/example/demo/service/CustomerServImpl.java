package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepo;

@Service("custserv")
public class CustomerServImpl implements CustomerService {

	@Autowired
	CustomerRepo custrepo;
	
	@Override
	public int saveCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return custrepo.saveCustomer(cust);
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return custrepo.getAllCustomers();
	}

	@Override
	public Customer getCustomerById(String cid) {
		// TODO Auto-generated method stub
		
		return custrepo.getCustomerById(cid);
	}

	@Override
	public int updateCustomer(Customer cust) {
		// TODO Auto-generated method stub
		return custrepo.updateCustomer(cust);
	}

}
