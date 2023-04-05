package com.example.demo.model;



public class Invoice_Product {


	private int inv_prod_id;
	
	private int qty;
	
	private float price;
	
	private float subtotal;
	
	private float total;
	
	private float cgst;
	
	private float sgst;
	
	private float igst;
	
	private int cgst_per;
	
	private int sgst_per;
	
	private int igst_per;
	
	private Long order_id;
	
	private Long prod_id;
	
	private Product product;
	
	


	public Long getProd_id() {
		return prod_id;
	}

	public void setProd_id(Long prod_id) {
		this.prod_id = prod_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getInv_prod_id() {
		return inv_prod_id;
	}

	public void setInv_prod_id(int inv_prod_id) {
		this.inv_prod_id = inv_prod_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
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

	public int getCgst_per() {
		return cgst_per;
	}

	public void setCgst_per(int cgst_per) {
		this.cgst_per = cgst_per;
	}

	public int getSgst_per() {
		return sgst_per;
	}

	public void setSgst_per(int sgst_per) {
		this.sgst_per = sgst_per;
	}

	public int getIgst_per() {
		return igst_per;
	}

	public void setIgst_per(int igst_per) {
		this.igst_per = igst_per;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	
	
	public Invoice_Product(int inv_prod_id, int qty, float price, float subtotal, float total, float cgst, float sgst,
			float igst, int cgst_per, int sgst_per, int igst_per, Long order_id, Long prod_id, Product product) {
		super();
		this.inv_prod_id = inv_prod_id;
		this.qty = qty;
		this.price = price;
		this.subtotal = subtotal;
		this.total = total;
		this.cgst = cgst;
		this.sgst = sgst;
		this.igst = igst;
		this.cgst_per = cgst_per;
		this.sgst_per = sgst_per;
		this.igst_per = igst_per;
		this.order_id = order_id;
		this.prod_id = prod_id;
		this.product = product;
	}

	public Invoice_Product() {}
	
	
}