package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.TaxRates;
import com.example.demo.service.TaxRateService;

@Controller
public class TaxRateController {

	@Autowired
	TaxRateService taxserv;
	
	@GetMapping("/addtaxrate")
	public String addtaxRate() {
		
		return "AddTaxRate";
	}
	
	@RequestMapping("/savetaxrate")
	public String saveTaxRate(@ModelAttribute("TaxRates")TaxRates taxrate,RedirectAttributes attr)
	{
		int res = taxserv.saveTaxRates(taxrate);
		
		if(res>0)
		{
			attr.addFlashAttribute("response", "TaxRate Saved Successfully");
			return "redirect:/viewtaxrate";
		}
		else {
			attr.addFlashAttribute("reserr", "TaxRate is not Saved ");
			return "redirect:/viewtaxrate";
		}
	}
	
	@GetMapping("/viewtaxrate")
	public String viewTaxRates(Model model)
	{
		List<TaxRates> taxlist = taxserv.getAllTaxRates();
		
		model.addAttribute("taxlist", taxlist);
		
		return "ViewTaxRates";
	}
	
	@GetMapping("/edittaxratebyid/{id}")
	public String edittaxratebyid(@PathVariable("id") String id,Model model,RedirectAttributes attr)
	{
	
		TaxRates trate = taxserv.getTaxRateById(id);
		
		if(trate!=null)
		{
			model.addAttribute("taxrate", trate);
			return "EditTaxRate";
		}
		else {
			attr.addFlashAttribute("reserr", "TaxRate is not found for given Id ");
			return "redirect:/viewtaxrate";
		}
	}
	
	
	@RequestMapping("/updatetaxrate")
	public String updateTaxRateById(@ModelAttribute("TaxRates")TaxRates trate,RedirectAttributes attr)
	{
		int res = taxserv.updateTaxRateById(trate);
		
		System.out.println("New rate is --> "+trate.getTaxrate());
		
		if(res >0)
		{
			attr.addFlashAttribute("response", "TaxRate is Updated successfully");
			return "redirect:/viewtaxrate";
		}
		else {
			attr.addFlashAttribute("reserr", "TaxRate is not updated for given Id ");
			return "redirect:/viewtaxrate";
		}
	}
	
}
