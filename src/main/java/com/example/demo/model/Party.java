package com.example.demo.model;

public class Party {

	private Long party_id;
	
	private String party_name;

	public Long getParty_id() {
		return party_id;
	}

	public void setParty_id(Long party_id) {
		this.party_id = party_id;
	}

	public String getParty_name() {
		return party_name;
	}

	public void setParty_name(String party_name) {
		this.party_name = party_name;
	}

	public Party(Long party_id, String party_name) {
		super();
		this.party_id = party_id;
		this.party_name = party_name;
	}
	
	
	public Party() {}
}
