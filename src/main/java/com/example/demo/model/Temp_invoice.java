package com.example.demo.model;


public class Temp_invoice {
	
	private Integer temp_id;
	
	private Integer temp_invoice_id;
	
	private Integer qty;
	
	private float unit_price;
	
	private String unit;
	
	private float total;
	
	private float vat_per;
	
	private float cgst;
	
	private float sgst;
	
	private float igst;
	
	private float cgst_per;
		
	private float sgst_per;
	
	private float igst_per;
	
	private float custom_price;
	
	private Product product;

	private Integer prod_id;
	
	private String prod_name;
	
	private Long prod_hsn;
	
	private String prod_model_no;

	private String prod_unit;

	private float prod_price;

	private float gsttax;
	
	
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

	private String stoption;
	
	public String getStoption() {
		return stoption;
	}

	public void setStoption(String stoption) {
		this.stoption = stoption;
	}

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public Integer getTemp_id() {
		return temp_id;
	}

	public void setTemp_id(Integer temp_id) {
		this.temp_id = temp_id;
	}

	public Integer getTemp_invoice_id() {
		return temp_invoice_id;
	}

	public void setTemp_invoice_id(Integer temp_invoice_id) {
		this.temp_invoice_id = temp_invoice_id;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public float getUnit_price() {
		return unit_price;
	}

	public void setUnit_price(float unit_price) {
		this.unit_price = unit_price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getVat_per() {
		return vat_per;
	}

	public void setVat_per(float vat_per) {
		this.vat_per = vat_per;
	}

	public float getCgst() {
		return cgst;
	}

	public void setCgst(float cgst) {
		this.cgst = cgst;
	}

	public float getSgst() {
		return sgst;
	}

	public void setSgst(float sgst) {
		this.sgst = sgst;
	}

	public float getIgst() {
		return igst;
	}

	public void setIgst(float igst) {
		this.igst = igst;
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

	public float getCustom_price() {
		return custom_price;
	}

	public void setCustom_price(float custom_price) {
		this.custom_price = custom_price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	
	public Temp_invoice(Integer temp_id, Integer temp_invoice_id, Integer qty, float unit_price, String unit,
			float total, float vat_per, float cgst, float sgst, float igst, float cgst_per, float sgst_per,
			float igst_per, float custom_price, Product product, Integer prod_id, String prod_name, Long prod_hsn,
			String prod_model_no, String prod_unit, float prod_price, float gsttax, String stoption) {
		super();
		this.temp_id = temp_id;
		this.temp_invoice_id = temp_invoice_id;
		this.qty = qty;
		this.unit_price = unit_price;
		this.unit = unit;
		this.total = total;
		this.vat_per = vat_per;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
		this.cgst_per = cgst_per;
		this.sgst_per = sgst_per;
		this.igst_per = igst_per;
		this.custom_price = custom_price;
		this.product = product;
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_hsn = prod_hsn;
		this.prod_model_no = prod_model_no;
		this.prod_unit = prod_unit;
		this.prod_price = prod_price;
		this.gsttax = gsttax;
		this.stoption = stoption;
	}

	public Temp_invoice() {}
}
