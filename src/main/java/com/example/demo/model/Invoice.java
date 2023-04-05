package com.example.demo.model;

import java.sql.Date;

public class Invoice {

	private Long invoice_id;
	
	private Long order_id;
	
	private Long invoice_no;
	
	private String prefix;
	
	private String store_name;
	 
	private String store_url;
	
	private Float total_amount;
	
	private Date date_added;
	
	private Date updated_date;
	
	private String vehicle;
	
	private String batch_no;

	private String orderponumber;

	private Long customer_id;
	
	private Customer customer;
	
	private Invoice_Product invprod;
	
	private Product product;
	
	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Invoice_Product getInvprod() {
		return invprod;
	}

	public void setInvprod(Invoice_Product invprod) {
		this.invprod = invprod;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Long getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(Long invoice_id) {
		this.invoice_id = invoice_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getInvoice_no() {
		return invoice_no;
	}

	public void setInvoice_no(Long invoice_no) {
		this.invoice_no = invoice_no;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getStore_url() {
		return store_url;
	}

	public void setStore_url(String store_url) {
		this.store_url = store_url;
	}

	public Float getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Float total_amount) {
		this.total_amount = total_amount;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getBatch_no() {
		return batch_no;
	}

	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}

	public String getOrderponumber() {
		return orderponumber;
	}

	public void setOrderponumber(String orderponumber) {
		this.orderponumber = orderponumber;
	}

	public Invoice(Long invoice_id, Long order_id, Long invoice_no, String prefix, String store_name, String store_url,
			Float total_amount, Date date_added, Date updated_date, String vehicle, String batch_no,
			String orderponumber) {
		super();
		this.invoice_id = invoice_id;
		this.order_id = order_id;
		this.invoice_no = invoice_no;
		this.prefix = prefix;
		this.store_name = store_name;
		this.store_url = store_url;
		this.total_amount = total_amount;
		this.date_added = date_added;
		this.updated_date = updated_date;
		this.vehicle = vehicle;
		this.batch_no = batch_no;
		this.orderponumber = orderponumber;
	}
	
	public Invoice() {}
}
