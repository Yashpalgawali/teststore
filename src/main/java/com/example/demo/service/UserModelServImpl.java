package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserModelRepository;

@Service("userserv")
public class UserModelServImpl implements UserModelService {

	@Autowired
	UserModelRepository userrepo;
	
	@Override
	public int saveUser(UserModel model) {
		// TODO Auto-generated method stub
		return userrepo.saveUser(model);
	}

	@Override
	public List<UserModel> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepo.getAllUsers();
	}

	@Override
	public UserModel getUserById(String id) {
		// TODO Auto-generated method stub
		return userrepo.getUserById(id);
	}

	@Override
	public int updateUser(UserModel model) {
		// TODO Auto-generated method stub
		return userrepo.updateUser(model);
	}

}
