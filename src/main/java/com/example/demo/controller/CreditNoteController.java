package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.InvoiceService;

@Controller
public class CreditNoteController {

	@Autowired
	InvoiceService invserv;
	
	@GetMapping("/addcredit")
	public String addCreditNote(Model model)
	{
		model.addAttribute("invlist", invserv.getAllInvoices());
		return "CreditNote";
	}
}
