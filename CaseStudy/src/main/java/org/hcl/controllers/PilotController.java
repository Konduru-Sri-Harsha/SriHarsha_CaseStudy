package org.hcl.controllers;

import java.util.List;

import javax.validation.Valid;

import org.hcl.dao.PilotDao;
import org.hcl.entities.Pilot;
import org.hcl.entities.Plane;
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
public class PilotController {
	@Autowired
	PilotDao pilotdao;
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
       
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

	@RequestMapping("/pilotprocess")
	public String addPilot(@Valid @ModelAttribute("pilot") Pilot pilot, BindingResult result, Model model) {
		if (result.hasErrors()) {
			String error = "* Required Fields";
			model.addAttribute("error", error);
			return "addpilot";
		} else {
			pilot.setStatus("Not Assigned");
			pilotdao.insertPilot(pilot);
			String message= "Your Details are submitted successfully";
			model.addAttribute("message", message);
			model.addAttribute("plane",new Plane());
			return "addpilot";
		}
		/*
		 * Pilot pilot= new Pilot(); pilot.setPilotName(pilotname);
		 * pilot.setGender(gender); pilot.setStatus("Not Assigned");
		 * pilotdao.insertPilot(pilot); String message=
		 * "Your Details are submitted successfully"; model.addAttribute("message",
		 * message); return "addpilot";
		 */
	}
	
	@RequestMapping("/pilotlist")
	public String viewPilots(Model model) {
		
		List<Pilot> pilots=pilotdao.getAllPilots();
		model.addAttribute("pilots", pilots);
		
		return "pilotlist";
	}

}
