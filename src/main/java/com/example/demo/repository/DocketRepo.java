package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Docket;

public interface DocketRepo {

public int saveDocket(Docket dock);
	
	public List<Docket> getAllDockets();
	
	public Docket getDocketById(String id);
	
	public int updateDocket(Docket dock);
	
}
