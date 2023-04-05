package com.example.demo.model;

public class Product {

	private Long prod_id;

	private String prod_name;

	private Long prod_hsn;

	private String prod_model_no;

	private String prod_unit;

	private float prod_price;

	private float gsttax;

	private float cgst_per;

	private float sgst_per;

	private float igst_per;

	public Product(Long prod_id, String prod_name, Long prod_hsn, String prod_model_no, String prod_unit,
			float prod_price, float gsttax, float cgst_per, float sgst_per, float igst_per) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_hsn = prod_hsn;
		this.prod_model_no = prod_model_no;
		this.prod_unit = prod_unit;
		this.prod_price = prod_price;
		this.gsttax = gsttax;
		this.cgst_per = cgst_per;
		this.sgst_per = sgst_per;
		this.igst_per = igst_per;
	}

	public Long getProd_id() {
		return prod_id;
	}

	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public Long getProd_hsn() {
		return prod_hsn;
	}

	public void setProd_hsn(Long prod_hsn) {
		this.prod_hsn = prod_hsn;
	}

	public String getProd_model_no() {
		return prod_model_no;
	}

	public void setProd_model_no(String prod_model_no) {
		this.prod_model_no = prod_model_no;
	}

	public String getProd_unit() {
		return prod_unit;
	}

	public void setProd_unit(String prod_unit) {
		this.prod_unit = prod_unit;
	}

	public float getProd_price() {
		return prod_price;
	}

	public void setProd_price(float prod_price) {
		this.prod_price = prod_price;
	}

	public float getGsttax() {
		return gsttax;
	}

	public void setGsttax(float gsttax) {
		this.gsttax = gsttax;
	}

	public float getCgst_per() {
		return cgst_per;
	}

	public void setCgst_per(float cgst_per) {
		this.cgst_per = cgst_per;
	}

	public float getSgst_per() {
		return sgst_per;
	}

	public void setSgst_per(float sgst_per) {
		this.sgst_per = sgst_per;
	}

	public float getIgst_per() {
		return igst_per;
	}

	public void setIgst_per(float igst_per) {
		this.igst_per = igst_per;
	}

	public Product() {
	}
}
