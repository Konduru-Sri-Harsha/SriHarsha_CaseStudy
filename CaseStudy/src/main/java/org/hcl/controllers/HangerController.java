package org.hcl.controllers;

import java.util.List;

import javax.validation.Valid;

import org.hcl.dao.HangerDao;
import org.hcl.entities.Hanger;
import org.hcl.entities.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		
	}
	
	@RequestMapping("/hangerlist")
	public String viewPilots(Model model) {
		
		List<Hanger> hangers= hangerdao.getAllHangers();
		model.addAttribute("hangers", hangers);
		
		return "hangerlist";
	}
	
	@RequestMapping("/hanger_update/{hangerId}")
	public String updateForm(@PathVariable("hangerId") Integer hangerId, Model model) {
		Hanger hanger= hangerdao.getHanger(hangerId);
		model.addAttribute("hanger", hanger);
		return "updatehanger";
	}
	@RequestMapping("/updatehanger_process")
	public String updateProcess(@RequestParam("id") Integer hangerId, @RequestParam("hangername") String hangername,
			@RequestParam("type") String type, Model model) {
		Hanger hanger= hangerdao.getHanger(hangerId);
		hanger.setHangerName(hangername);
		hanger.setHangerType(type);
		
		boolean b=hangerdao.updateHanger(hanger);
		if(b) {
		String message = "Hanger Details updated";
		model.addAttribute("message", message);
		return "updatehanger";
		}
		else {
			String message = "Hanger Details not updated";
			model.addAttribute("message", message);
			return "updatehanger";
		}
	}
	
}
