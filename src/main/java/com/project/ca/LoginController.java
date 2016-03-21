package com.project.ca;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.ca.service.StaffService;

///**
// * Handles requests for the application home page.
// */
@Controller
public class LoginController {

	@Autowired
	private StaffService soukrce;

	String Staff;

	@RequestMapping(value = "/index_process", method = RequestMethod.POST)
	public String newindexpage(@RequestParam String empId,
			@RequestParam String empPass, Model model,
			HttpServletRequest request) {
		String s1 = "suria";
		int s = soukrce.checkpassword(empId, empPass);
		if (s == 1) {

			request.getSession().setAttribute("name", empId);

			return "/Admin";
		}

		else if (s == 2) {
			//request.getSession().setAttribute("name", empId);
			model.addAttribute("Manager", s);
			System.out.println(request.getRequestedSessionId());
			request.getSession().setAttribute("name", empId);
			return "Manager/Manager";
		} else if (s == 3) {
			//request.getSession().setAttribute("name", empId);
			model.addAttribute("Staff", s);
			request.getSession().setAttribute("name", empId);
			return "Staff/Staff";
		} else {
			model.addAttribute("error", "enter right username/password");
			return "index";
		}
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String newindextest(HttpServletRequest request) {
		request.getSession().removeAttribute("name");
		return "index";
	}
	
	@RequestMapping(value = "/Staff/Staff", method = RequestMethod.GET)
	public String staffHomePage() {

		return "/Staff/Staff";
	}
	
	@RequestMapping(value = "/Manager/Manager", method = RequestMethod.GET)
	public String managerHomePage() {

		return "/Manager/Manager";
	}

}
