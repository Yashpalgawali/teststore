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

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService prodserv;
	
	@GetMapping("/addproduct")
	public String addProduct()
	{
		return "AddProduct";
	}
	
	@GetMapping("viewproducts")
	public String viewProducts(Model model)
	{
		List<Product> plist = prodserv.getAllProducts();
		
		model.addAttribute("plist", plist);
				
		return "ViewProducts";
	}
	
	@RequestMapping("/saveproduct")
	public String saveProduct(@ModelAttribute("Product") Product prod,RedirectAttributes attr)
	{	
		Float cgsts = Float.valueOf(prod.getGsttax());
		
		float cgst = (cgsts) / 2;
		
		Float igsts = Float.valueOf(prod.getGsttax());
		
		float igst = igsts;
		
		prod.setCgst_per(cgst);
		
		prod.setSgst_per(cgst);
		prod.setIgst_per(igst);
	
		boolean res = prodserv.isSaveProduct(prod);
		
		if(res)
		{
			attr.addFlashAttribute("response", "Product "+prod.getProd_name()+" saved successfully");
			return "redirect:/viewproducts";
		}
		else
		{	
			attr.addFlashAttribute("reserr", "Product "+prod.getProd_name()+" is not saved ");
			return "redirect:/viewproducts";
		}
	}
	
	@RequestMapping("editprodbyid/{id}")
	public String editProducById(@PathVariable("id") String id,Model model,RedirectAttributes attr)
	{
		Product prod = prodserv.getProductById(id);
		if(prod!=null)
		{
			model.addAttribute("prod", prod);
			return "EditProduct";
		}
		else
		{
			attr.addFlashAttribute("reserr", "No product found for given ID");
			return "redirect:/viewproducts";
		}
	}
	
	@RequestMapping("/updateproduct")
	public String updateProduct(@ModelAttribute("Product")Product prod,RedirectAttributes attr)
	{
		int res = prodserv.updateProduct(prod);
		if(res >0 )
		{
			attr.addFlashAttribute("response", "Product "+prod.getProd_name()+" updated successfully");
			return "redirect:/viewproducts";
		}
		else
		{	
			attr.addFlashAttribute("reserr", "Product "+prod.getProd_name()+" is not updated ");
			return "redirect:/viewproducts";
		}
	}
	
	@RequestMapping("/getproductsbyinvid/{id}")
	@ResponseBody
	public List<Product> getproductsbyInvoiceId(@PathVariable("id")Long id)
	{
		
		return prodserv.getproductsbyInvoiceId(id);
	}
}
