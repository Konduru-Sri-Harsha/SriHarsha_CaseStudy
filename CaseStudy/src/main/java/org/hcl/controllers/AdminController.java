package org.hcl.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hcl.dao.AdminDao;
import org.hcl.entities.Hanger;
import org.hcl.entities.Manager;
import org.hcl.entities.Pilot;
import org.hcl.entities.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
	@Autowired
	AdminDao admindao;
	
	@RequestMapping("/adminlogin")
	public String login() {
		return "adminlogin";
	}
	@RequestMapping("/adminhome")
	public String home() {
		return "adminhome";
	}

	@PostMapping("/adminauthenticate")
	public String authenticate(@RequestParam("firstname") String username, @RequestParam("password") String password,
			HttpSession session, HttpServletRequest request, Model model) {
		
		boolean valid = admindao.validate(username, password);
		if (valid) {
			session = request.getSession();
			session.setAttribute("admin", username);
			model.addAttribute("adminName", username);
			return "adminhome";
		}
		String message = "Enter valid username or password";
		model.addAttribute("message", message);
		return "adminlogin";
	}
	
	@RequestMapping(value="/adminlogout")
	public String Logout(HttpSession session,HttpServletRequest request,Model model){
		HttpSession session2 = request.getSession(false);
		session2.removeAttribute("admin");
		if(session2!=null){
			session2.invalidate();
		}
		String message="Admin Successfully Logged Out";
		model.addAttribute("message", message);
		return "logout";
	}
	
	
	@RequestMapping("/managerlist")
	public String managerlist(Model model) {
		List<Manager> list= admindao.getAllMangers();
		model.addAttribute("list", list);
		return "managerlist";
	}
	@RequestMapping("/approve/{managerId}")
	public String approve(@PathVariable("managerId") Integer id,Model model) {
		
		admindao.approveManager(id);
		String message="Manager status approved";
		model.addAttribute("message", message);
		return "show";
		
	}
	
	@RequestMapping("/delete/{managerId}")
	public String delete(@PathVariable("managerId") Integer id,Model model) {
		
		admindao.deleteManager(id);
		String message="Deleted Manager";
		model.addAttribute("message", message);
		return "show";
		
	}	
	
	@RequestMapping("/addplane")
	public String addPlanePage(Model model) {
		model.addAttribute("plane", new Plane());
		return "addplane";
	}
	
	@RequestMapping("/addpilot")
	public String addPilotPage(Model model) {
		model.addAttribute("pilot", new Pilot());
		return "addpilot";
	}
	
	@RequestMapping("/addhanger")
	public String addHangerPage(Model model) {
		model.addAttribute("hanger", new Hanger());
		return "addhanger";
	}
}


