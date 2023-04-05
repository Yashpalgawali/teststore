package com.example.demo.model;

public class GstTax {

	private Long gst_tax_id;
	
	private Long taxrate;

	public Long getGst_tax_id() {
		return gst_tax_id;
	}

	public void setGst_tax_id(Long gst_tax_id) {
		this.gst_tax_id = gst_tax_id;
	}

	public Long getTaxrate() {
		return taxrate;
	}

	public void setTaxrate(Long taxrate) {
		this.taxrate = taxrate;
	}

	public GstTax(Long gst_tax_id, Long taxrate) {
		super();
		this.gst_tax_id = gst_tax_id;
		this.taxrate = taxrate;
	}
	
	public GstTax() {}
	
}
