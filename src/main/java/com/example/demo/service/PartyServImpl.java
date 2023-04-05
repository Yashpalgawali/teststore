package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Party;
import com.example.demo.repository.PartyRepository;

@Service("partyserv")
public class PartyServImpl implements PartyService {

	@Autowired
	PartyRepository partyrepo;
	
	@Override
	public int saveParty(Party party) {
		// TODO Auto-generated method stub
		return partyrepo.saveParty(party);
	}

	@Override
	public List<Party> getAllParties() {
		// TODO Auto-generated method stub
		return partyrepo.getAllParties();
	}

	@Override
	public Party getPartyById(String id) {
		// TODO Auto-generated method stub
		return partyrepo.getPartyById(id);
	}

	@Override
	public int updateParty(Party party) {
		// TODO Auto-generated method stub
		return partyrepo.updateParty(party);
	}

}
