package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerService {

	public int saveCustomer(Customer cust);
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(String cid);
	
	public int updateCustomer(Customer cust);
}
