package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerRepo {


	public int saveCustomer(Customer cust);
	
	public List<Customer> getAllCustomers();
	
	public Customer getCustomerById(String cid);
	
	public int updateCustomer(Customer cust);
}
