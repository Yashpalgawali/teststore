package com.example.demo.model;

public class Customer {

	private Long cust_id;
	
	private String cust_first_name;
	
	private String cust_last_name;
	
	private String cust_email;
	
	private Long cust_contact;
	
	private String cust_address;
	
	private String state_name;
	
	private String city_name;
	
	private Long pincode;
	
	private String cust_gst;
	
	private String cust_country;
	
	

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_first_name() {
		return cust_first_name;
	}

	public void setCust_first_name(String cust_first_name) {
		this.cust_first_name = cust_first_name;
	}

	public String getCust_last_name() {
		return cust_last_name;
	}

	public void setCust_last_name(String cust_last_name) {
		this.cust_last_name = cust_last_name;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	public Long getCust_contact() {
		return cust_contact;
	}

	public void setCust_contact(Long cust_contact) {
		this.cust_contact = cust_contact;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public String getCity_name() {
		return city_name;
	}

	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCust_gst() {
		return cust_gst;
	}

	public void setCust_gst(String cust_gst) {
		this.cust_gst = cust_gst;
	}

	public String getCust_country() {
		return cust_country;
	}

	public void setCust_country(String cust_country) {
		this.cust_country = cust_country;
	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public Customer(Long cust_id, String cust_first_name, String cust_last_name, String cust_email, Long cust_contact,
			String cust_address, String state_name, String city_name, Long pincode, String cust_gst,
			String cust_country) {
		super();
		this.cust_id = cust_id;
		this.cust_first_name = cust_first_name;
		this.cust_last_name = cust_last_name;
		this.cust_email = cust_email;
		this.cust_contact = cust_contact;
		this.cust_address = cust_address;
		this.state_name = state_name;
		this.city_name = city_name;
		this.pincode = pincode;
		this.cust_gst = cust_gst;
		this.cust_country = cust_country;
	}
	
	public Customer() {}
}
