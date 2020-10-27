package org.hcl.controllers;

import java.util.List;

import javax.validation.Valid;

import org.hcl.dao.planeDao;
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
public class PlaneController {
	@Autowired
	planeDao planedao;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/planeprocess")
	public String addplanes(@Valid @ModelAttribute("plane") Plane plane, BindingResult result, Model model) {
		if (result.hasErrors()) {
			String error = "* Required Fields";
			model.addAttribute("error", error);
			return "addplane";
		} else {
			plane.setStatus("Waiting");
			planedao.insertPlane(plane);
			String message = "Your Details are submitted successfully";
			model.addAttribute("message", message);
			model.addAttribute("plane", new Plane());
			model.addAttribute("message", message);
			return "addplane";
		}

	}

	@RequestMapping("/planelist")
	public String viewPlanes(Model model) {

		List<Plane> planes = planedao.getAllPlanes();
		model.addAttribute("planes", planes);

		return "planelist";
	}

	@RequestMapping("/plane_update/{planeId}")
	public String updateForm(@PathVariable("planeId") Integer planeId, Model model) {
		Plane plane = planedao.getplane(planeId);
		model.addAttribute("plane", plane);
		return "updateplane";
	}

	@RequestMapping("/updateplane_process/{planeId}")
	public String updateProcess(@PathVariable("planeId") Integer planeId, @RequestParam("planename") String planename,
			@RequestParam("from") String from, @RequestParam("to") String to, Model model,@ModelAttribute("plane") Plane plane) {

		
		plane.setPlaneName(planename);
		plane.setFrom(from);
		plane.setTo(to);
		planedao.updatePlane(plane);
		String message = "Plane Details updated";
		model.addAttribute("message", message);
		return "updateplane";
	}

}
