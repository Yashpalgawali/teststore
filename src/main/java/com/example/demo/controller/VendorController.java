package com.example.demo.controller;

import java.rmi.server.RMIClassLoader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Vendor;
import com.example.demo.service.VendorService;

@Controller
public class VendorController {

	@Autowired
	VendorService vendorserv;
	
	@GetMapping("/addvendor")
	public String addVendor()
	{
		return "AddVendor";
	}
	
	@RequestMapping("savevendor")
	public String saveVendor(@ModelAttribute("Vendor")Vendor vendor,RedirectAttributes attr)
	{	
		int vend = vendorserv.saveVendor(vendor);
		
		if(vend> 0)
		{
			attr.addFlashAttribute("response", "Vendor added successfully");
			return "redirect:/viewvendors";
		}
		attr.addFlashAttribute("reserr", "Vendor is not added ");
		return "redirect:/viewvendors";
	}

	@RequestMapping("/viewvendors")
	public String viewVendors(Model model)
	{
		List<Vendor> vend = vendorserv.getAllVendors();
		model.addAttribute("vendor", vend);
		
		return "ViewVendors";
	}
	
	@RequestMapping("editvendorbyid/{id}")
	public String enditVendorById(@PathVariable("id") String id,Model model)
	{
		Vendor vend = vendorserv.getVendorById(id);
	
		model.addAttribute("vendor", vend);
		return "EditVendor";
	}
	
	@RequestMapping("updatevendor")
	public String updateVendor(@ModelAttribute("Vendor") Vendor vend,RedirectAttributes attr)
	{
		int val = vendorserv.updateVendor(vend);
		
		if(val > 0 )
		{
			attr.addFlashAttribute("response", "Vendor "+vend.getVendor_name()+" is Updated successfully");
			return "redirect:/viewvendors";
		}
		else {
			attr.addFlashAttribute("reserr", "Vendor "+vend.getVendor_name()+" is not Updated ");
			return "redirect:/viewvendors";
		}
	}
}
