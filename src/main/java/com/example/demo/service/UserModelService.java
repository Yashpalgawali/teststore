package com.example.demo.service;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserModelService {

public int saveUser(UserModel model);
	
	public List<UserModel> getAllUsers();
	
	public UserModel getUserById(String id);
	
	public int updateUser(UserModel model);
	
}
