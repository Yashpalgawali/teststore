package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserModelRepository {

	public int saveUser(UserModel model);
	
	public List<UserModel> getAllUsers();
	
	public UserModel getUserById(String id);
	
	public int updateUser(UserModel model);
	
}
