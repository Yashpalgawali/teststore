package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.example.demo.model.UserModel;
import com.example.demo.service.UserModelService;

@Controller
public class UserController {

	@Autowired
	UserModelService userserv;
	
	@GetMapping("/adduser")
	public String addUser()
	{
		
		return "AddUser";
	}
	
	@RequestMapping("/saveuser")@ResponseBody
	public String saveUser(@ModelAttribute("UserModel")UserModel user,RedirectAttributes attr)
	{
		
		int res = userserv.saveUser(user);
		if(res >0) 
		{
			attr.addAttribute("response", "User saved successfully");
		}
		
		return "redirect:/viewusers";
	}
	
	@GetMapping("/viewusers")
	public String viewUsers(Model model)
	{
		List<UserModel> ulist = null;
		
		model.addAttribute("ulist", ulist);
		return "ViewUsers";
	}
}
