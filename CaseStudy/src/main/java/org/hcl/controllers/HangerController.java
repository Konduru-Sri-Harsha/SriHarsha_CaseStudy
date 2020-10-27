package org.hcl.controllers;

import java.util.List;

import javax.validation.Valid;

import org.hcl.dao.HangerDao;
import org.hcl.entities.Hanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HangerController {
	@Autowired
	HangerDao hangerdao;
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
       
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

	
	@RequestMapping("/hangerprocess")
	public String addHanger(@Valid @ModelAttribute("hanger") Hanger hanger, BindingResult result, Model model) {
		if (result.hasErrors()) {
			String error = "* Required Fields";
			model.addAttribute("error", error);
			return "addhanger";
		} else {
			hanger.setStatus("Available");
			hangerdao.insertHanger(hanger);
			String message= "Your Details are submitted successfully";
			model.addAttribute("message", message);
			model.addAttribute("hanger",new Hanger());
			return "addhanger";
			
			
			
		}
		/*
		 * Hanger hanger= new Hanger(); hanger.setHangerName(hangername);
		 * hanger.setHangerType(type); hanger.setStatus("Available");
		 * hangerdao.insertHanger(hanger); String message=
		 * "Your Details are submitted successfully"; model.addAttribute("message",
		 * message); return "addhanger";
		 */
	}
	
	@RequestMapping("/hangerlist")
	public String viewPilots(Model model) {
		
		List<Hanger> hangers= hangerdao.getAllHangers();
		model.addAttribute("hangers", hangers);
		
		return "hangerlist";
	}
	
}
