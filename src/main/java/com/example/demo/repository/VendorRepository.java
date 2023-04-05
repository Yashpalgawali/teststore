package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Vendor;

public interface VendorRepository {

	public int saveVendor(Vendor vendor);
	
	public List<Vendor> getAllVendors();
	
	public Vendor getVendorById(String vid);
	
	public int updateVendor(Vendor vendor);
}
