package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired	
	CustomerService custserv;
	
	@GetMapping("addcustomer")
	public String addCustomer()
	{
		return "AddCustomer";
	}
	
	@RequestMapping("savecustomer")
	public String saveCustomer(@ModelAttribute("Customer") Customer cust,RedirectAttributes attr)
	{
		int custom = custserv.saveCustomer(cust);
		
		if(custom > 0){
			attr.addFlashAttribute("response", "Customer is saved Successfully");
			return "redirect:/viewcustomers";
		}
		else{
			attr.addFlashAttribute("reserr", "Customer is not saved ");
			return "redirect:/viewcustomers";
		}
	}
	
	@RequestMapping("/viewcustomers")
	public String viewCustomers(Model model)
	{
		List<Customer> clist = custserv.getAllCustomers();
		model.addAttribute("clist", clist);
		
		return "ViewCustomers";
	}
	
	@RequestMapping("/editcustbyid/{id}")
	public String editCutomerById(@PathVariable("id") String id,Model model,RedirectAttributes attr)
	{
		Customer cust = custserv.getCustomerById(id);
		
		if(cust!=null){
			model.addAttribute("cust", cust);
			return "EditCustomer";
		}
		else {
			attr.addFlashAttribute("reserr", "Customer not found");
			return "redirect:/viewcustomers";
		}
	}
	
	@RequestMapping("/updatecustomer")
	public String updateCustomer(@ModelAttribute("Customer") Customer cust,RedirectAttributes attr)
	{
		int value = custserv.updateCustomer(cust);
		
		if(value > 0){
			attr.addFlashAttribute("response", "Customer "+cust.getCust_first_name()+" "+cust.getCust_last_name()+" Updated successfully");
			return "redirect:/viewcustomers";
		}
		else {
			attr.addFlashAttribute("reserr", cust.getCust_first_name()+" Customer details not updated");
			return "redirect:/viewcustomers";
		}
	}
}
