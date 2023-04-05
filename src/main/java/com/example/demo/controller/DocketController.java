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

import com.example.demo.model.Docket;
import com.example.demo.model.Party;
import com.example.demo.service.DocketService;
import com.example.demo.service.PartyService;

@Controller
public class DocketController {

	@Autowired
	DocketService dockserv;
	
	
	@Autowired
	PartyService partyserv;
	
	@GetMapping("/adddocket")
	public String addDocket(Model model)
	{
		List<Party> plist= partyserv.getAllParties();
		
		model.addAttribute("plist", plist);
		
		return "AddDocket";
	}
	
	@RequestMapping("/savedocket")
	public String saveDocket(@ModelAttribute("Docket")Docket dock,RedirectAttributes attr)
	{
		int docket = dockserv.saveDocket(dock);
		
		if(docket > 0){
			attr.addFlashAttribute("response", "Docket saved successfully");
			return "redirect:/viewdockets";
		}
		else{
			attr.addFlashAttribute("reserr", "Docket is not saved ");
			return "redirect:/viewdockets";
		}
	}
	
	
	@RequestMapping("/viewdockets")
	public String viewDocket(Model model)
	{
		List<Docket> dlist = dockserv.getAllDockets();
		
		model.addAttribute("plist", dlist);
		return "ViewDockets";
	}
	
	@RequestMapping("/editdocketbyid/{id}")
	public String editDocketById(@PathVariable("id") String id,Model model,RedirectAttributes attr)
	{
		Docket dock = dockserv.getDocketById(id);
		
		System.out.println("result from service is "+dock+"\n");
		
		List<Party> part = partyserv.getAllParties();
		
		if(dock !=null)
		{
			model.addAttribute("dock", dock);
			model.addAttribute("plist", part);
			
			return "EditDocket";
		}
		
		attr.addFlashAttribute("reserr", "Docket Not found");
		return "redirect:/viewdockets";
	}
	
	@RequestMapping("/updatedocket")
	public String updateDocket(@ModelAttribute("Docket") Docket dock,RedirectAttributes attr)
	{
		int value = dockserv.updateDocket(dock);
		
		if(value > 0 )
		{
			attr.addFlashAttribute("response", "Docket is Updated successfully");
			return "redirect:/viewdockets";
		}
		else
		{
			attr.addFlashAttribute("reserr", "Docket is not updated ");
			return "redirect:/viewdockets";
		}
	}
	
}
