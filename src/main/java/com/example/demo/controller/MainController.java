package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String homePage()
	{
		LocalDate ldate = LocalDate.now();
		
		System.err.println("Todays date is --> "+ldate);
		
		return "Home";
	}
	
}
