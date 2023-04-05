package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Vendor;

public interface VendorService {

public int saveVendor(Vendor vendor);
	
	public List<Vendor> getAllVendors();
	
	public Vendor getVendorById(String vid);
	
	public int updateVendor(Vendor vendor);
}
