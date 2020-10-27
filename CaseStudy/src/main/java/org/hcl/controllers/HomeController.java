package org.hcl.controllers;

import javax.validation.Valid;

import org.hcl.dao.AdminDao;
import org.hcl.dao.ManagerDao;
import org.hcl.entities.Admin;
import org.hcl.entities.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {
	@Autowired
	AdminDao admindao;
	@Autowired
	ManagerDao managerdao;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	@InitBinder
    public void initBinder(WebDataBinder dataBinder) {
       
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
	@GetMapping("/adminreg")
	public String adminReg(Model model) {
		model.addAttribute("admin1", new Admin());
		return "adminreg";
	}

	@GetMapping("/managerreg")
	public String managerReg(Model model) {
		model.addAttribute("manager", new Manager());
		return "managerreg";
	}

	@PostMapping("/adminprocess")
	public String adminForm(@Valid @ModelAttribute("admin1") Admin admin1, BindingResult result, Model model) {
		if (result.hasErrors()) {
			String error = "* Required Fields";
			model.addAttribute("error", error);
			return "adminreg";
		} else {
			
			admindao.insertAdmin(admin1);
			String message = "Your data is submitted successfully";
			model.addAttribute("admin1", new Admin());
			model.addAttribute("message", message);
			return "adminreg";
		}

		/*
		 * Admin admin= new Admin(); admin.setFirstName(firstname);
		 * admin.setLastName(lastname); admin.setAge(age); admin.setGender(gender);
		 * admin.setContactNumber(contactnumber); admin.setPassword(password);
		 * admindao.insertAdmin(admin); String message=
		 * "Your data is submitted successfully"; model.addAttribute("message",
		 * message); return "adminreg";
		 */
	}

	@PostMapping("/managerprocess")
	public String managerForm(@Valid @ModelAttribute("manager") Manager manager, BindingResult result, Model model) {
		if (result.hasErrors()) {
			String error = "* Required Fields";
			model.addAttribute("error", error);
			return "managerreg";
		} else {
			manager.setStatus("Not approved");
			managerdao.insertManager(manager);
			String message = "Your data is submitted successfully";
			model.addAttribute("manager",new Manager());
			model.addAttribute("message", message);
			return "managerreg";
		}
		/*
		 * Manager manager = new Manager(); manager.setFirstName(firstname);
		 * manager.setLastName(lastname); manager.setAge(age);
		 * manager.setGender(gender); manager.setContactNumber(contactnumber);
		 * manager.setPassword(password); manager.setStatus("Not approved");
		 * managerdao.insertManager(manager); String message =
		 * "Your data is submitted successfully"; model.addAttribute("message",
		 * message); return "managerreg";
		 */
	}
}
