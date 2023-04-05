package com.example.demo.model;

public class Vendor {

	
	private Long vendor_id;
	
	private String vendor_name;
	
	private String vendor_email;
	
	private Long vendor_contact;
	
	private String vendor_gst;
	
	private String vendor_address;
	
	private String city_name;
	
	private String state_name;
	
	private Long pincode;

	public Long getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(Long vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getVendor_name() {
		return vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	public String getVendor_email() {
		return vendor_email;
	}

	public void setVendor_email(String vendor_email) {
		this.vendor_email = vendor_email;
	}

	public Long getVendor_contact() {
		return vendor_contact;
	}

	public void setVendor_contact(Long vendor_contact) {
		this.vendor_contact = vendor_contact;
	}

	public String getVendor_gst() {
		return vendor_gst;
	}

	public void setVendor_gst(String vendor_gst) {
		this.vendor_gst = vendor_gst;
	}

	public String getVendor_address() {
		return vendor_address;
	}

	public void setVendor_address(String vendor_address) {
		this.vendor_address = vendor_address;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public Vendor(Long vendor_id, String vendor_name, String vendor_email, Long vendor_contact, String vendor_gst,
			String vendor_address, String city_name, String state_name, Long pincode) {
		super();
		this.vendor_id = vendor_id;
		this.vendor_name = vendor_name;
		this.vendor_email = vendor_email;
		this.vendor_contact = vendor_contact;
		this.vendor_gst = vendor_gst;
		this.vendor_address = vendor_address;
		this.city_name = city_name;
		this.state_name = state_name;
		this.pincode = pincode;
	}
	
	public Vendor() {}
}
