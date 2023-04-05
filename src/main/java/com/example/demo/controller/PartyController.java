package com.example.demo.controller;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Party;
import com.example.demo.service.PartyService;

@Controller
public class PartyController {

	@Autowired	
	PartyService partyserv;
	
	@GetMapping("/addparty")
	public String addParty(){
		return "AddParty";
	}
	
	@PostMapping("/saveparty")
	public String saveParty(@ModelAttribute("Party") Party party,RedirectAttributes attr)
	{
		int part = partyserv.saveParty(party);
		
		if(part > 0){
			attr.addFlashAttribute("response", "Party "+party.getParty_name()+" saved successfully");
			return "redirect:/viewparty";
		}
		else {
			attr.addFlashAttribute("reserr", "Party "+party.getParty_name()+" is not saved ");
			return "redirect:/viewparty";
		}
	}
	
	@GetMapping("/viewparty")
	public String viewParties(Model model)
	{
		List<Party> plist = partyserv.getAllParties();
		// List Conversion to Set
//		Set<Party> pset =  plist.stream().distinct().collect(Collectors.toSet());
//		pset.stream().forEach(e->System.err.println(e.getParty_name()));
		
		model.addAttribute("plist", plist);
		return "ViewParty";
	}
	
	@RequestMapping("/editpartybyid/{id}")
	public String editPartyById(@PathVariable("id") String id,Model model,RedirectAttributes attr)
	{
		Party part = partyserv.getPartyById(id);
		
		if(part!=null){
			model.addAttribute("party", part);
			return "EditParty";
		}
		else{
			attr.addFlashAttribute("reserr","Party not found");
			return "redirect:/viewparty";
		}
	}
	
	@RequestMapping("/updateparty")
	public String updateParty(@ModelAttribute("Party")Party party,RedirectAttributes attr)
	{
		int value = partyserv.updateParty(party);
		
		if(value > 0){
			attr.addFlashAttribute("response", "Party is updated successfully");
			return "redirect:/viewparty";
		}
		else{
			attr.addFlashAttribute("reserr", "Party is not updated ");
			return "redirect:/viewparty";
		}
	}
	
}
