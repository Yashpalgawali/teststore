package com.example.demo.repository;

import java.util.List;
import java.util.Set;

import com.example.demo.model.Party;

public interface PartyRepository {

	public int saveParty(Party party);
	
	public List<Party> getAllParties();
	
	public Party getPartyById(String id);
	
	public int updateParty(Party party);
	
}
