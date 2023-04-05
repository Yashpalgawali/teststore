package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Vendor;
import com.example.demo.repository.VendorRepository;

@Service("vendserv")
public class VendorServImpl implements VendorService {

	@Autowired
	VendorRepository vendrepo;
	
	@Override
	public int saveVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendrepo.saveVendor(vendor);
	}

	@Override
	public List<Vendor> getAllVendors() {
		// TODO Auto-generated method stub
		return vendrepo.getAllVendors();
	}

	@Override
	public Vendor getVendorById(String vid) {
		// TODO Auto-generated method stub
		return vendrepo.getVendorById(vid);
	}

	@Override
	public int updateVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		return vendrepo.updateVendor(vendor);
	}

}
