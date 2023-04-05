package com.example.demo.model;

public class Docket {

	private Long docket_id;
	
	private Long docket_num;
	
	private Long order_id;
	
	private String cust_name;
	
	private Long party_id;
	
	private String party_name;
	
	

	public Docket(Long docket_id, Long docket_num, Long order_id, String cust_name, Long party_id, String party_name) {
		super();
		this.docket_id = docket_id;
		this.docket_num = docket_num;
		this.order_id = order_id;
		this.cust_name = cust_name;
		this.party_id = party_id;
		this.party_name = party_name;
	}

	public String getParty_name() {
		return party_name;
	}

	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}

	public Long getDocket_id() {
		return docket_id;
	}

	public void setDocket_id(Long docket_id) {
		this.docket_id = docket_id;
	}

	public Long getDocket_num() {
		return docket_num;
	}

	public void setDocket_num(Long docket_num) {
		this.docket_num = docket_num;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

	public Long getParty_id() {
		return party_id;
	}

	public void setParty_id(Long party_id) {
		this.party_id = party_id;
	}

	
	
	public Docket() {}
	
}
