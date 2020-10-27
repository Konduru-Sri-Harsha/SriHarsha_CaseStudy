package org.hcl.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hcl.dao.HangerDao;
import org.hcl.dao.ManagerDao;
import org.hcl.dao.PilotDao;
import org.hcl.dao.planeDao;
import org.hcl.entities.Hanger;
import org.hcl.entities.Pilot;
import org.hcl.entities.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagerController {
	@Autowired
	ManagerDao managerdao;
	@Autowired
	HangerDao hangerdao;
	@Autowired
	planeDao planedao;
	@Autowired
	PilotDao pilotdao;
	@RequestMapping("/managerlogin")
	public String login() {
		return "managerlogin";
	}
	@RequestMapping("/managerhome")
	public String home() {
		return "managerhome";
	}
	
	@PostMapping("/managerauthenticate")
	public String authenticate(@RequestParam("firstname") String username, @RequestParam("password") String password,
			HttpSession session, HttpServletRequest request, Model model) {

		boolean valid = managerdao.validate(username, password);
		if (valid) {
			session = request.getSession();
			session.setAttribute("manager", username);
			model.addAttribute("managerName", username);
			return "managerhome";
		}
		String message = "Enter valid username or password";
		model.addAttribute("message", message);
		return "managerlogin";
	}
	
	@RequestMapping(value="/managerlogout")
	public String Logout(HttpSession session,HttpServletRequest request,Model model){
		HttpSession session2 = request.getSession(false);
		session2.removeAttribute("admin");
		if(session2!=null){
			session2.invalidate();
		}
		String message="Manager Successfully Logged Out";
		model.addAttribute("message", message);
		return "logout";
	}
	@RequestMapping("/allothanger")
	public String allotHanger(Model model) {
		List<Hanger> hangers= hangerdao.availableHangers();
		model.addAttribute("hangers", hangers);
		List<Plane> planes= planedao.waitingPlanes();
		model.addAttribute("planes", planes);
		return "allothanger";
	}
	@RequestMapping("/allot_hangerprocess")
	public String allotHanger(@RequestParam("planeId") Integer planeId,@RequestParam("hangerId") Integer hangerId,Model model) {
		
		hangerdao.hangerStatus(hangerId);
		planedao.setStatus(planeId);
		planedao.setHangerId(planeId, hangerId);
		String message= "Status updated";
		model.addAttribute("message", message);
		return "showmanager";
	}
	@RequestMapping("/pilotassign")
	public String assignpilot(Model model) {
		List<Plane> planes= planedao.notAssignedPlanes();
		model.addAttribute("planes", planes);
		List<Pilot> pilots= pilotdao.notAssignedPilots();
		model.addAttribute("pilots", pilots);
		return "assignpilot";
	}
	@RequestMapping("/assign_pilotprocess")
	public String assignPilot(@RequestParam("planeId") Integer planeId,@RequestParam("pilotId") Integer pilotId,Model model) {
		
		pilotdao.updateStatus(pilotId);
		planedao.setPilotId(planeId, pilotId);
		String message= "Status updated";
		model.addAttribute("message", message);
		return "showmanager";
	}
}
