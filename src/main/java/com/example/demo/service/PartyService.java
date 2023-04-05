package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Party;

public interface PartyService {

	public int saveParty(Party party);
	
	public List<Party> getAllParties();
	
	public Party getPartyById(String id);
	
	public int updateParty(Party party);
	
}
