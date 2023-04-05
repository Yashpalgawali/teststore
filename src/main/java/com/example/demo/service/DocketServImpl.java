package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Docket;
import com.example.demo.repository.DocketRepo;

@Service("dockserv")
public class DocketServImpl implements DocketService {

	@Autowired
	DocketRepo dockrepo;
	
	@Override
	public int saveDocket(Docket dock) {
		// TODO Auto-generated method stub
		return dockrepo.saveDocket(dock);
	}

	@Override
	public List<Docket> getAllDockets() {
		// TODO Auto-generated method stub
		return dockrepo.getAllDockets();
	}

	@Override
	public Docket getDocketById(String id) {
		// TODO Auto-generated method stub
		
		return dockrepo.getDocketById(id);
		
	}

	@Override
	public int updateDocket(Docket dock) {
		// TODO Auto-generated method stub
		
		return dockrepo.updateDocket(dock);
	}


}
