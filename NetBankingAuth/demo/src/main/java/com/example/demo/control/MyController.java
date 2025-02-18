package com.example.demo.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	static {
		Database.initialize();
	}
	
	@RequestMapping("/")
	public String getFirstPage() {
		return "index.html";
	}
	
	@RequestMapping("/signup")
	public String getSignUp() {
		return "signup.html";
	}
	
	@RequestMapping("/signin")
	public String getLogin() {
		return "login.html";
	}
	
	@RequestMapping("/insertDetails")
	public ModelAndView setDetails(String id, String name, String pwd) {
		ModelAndView mv = new ModelAndView();
		
		if(!Database.isIdPresent(id)) {
			Database.createCustomer(id, name, pwd);
			mv.addObject("uname", name);
			mv.setViewName("welcome.jsp");
		}else {
			mv.setViewName("failure.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/verifymv")
	public ModelAndView verifyUserMv(String id, String pwd) {
		ModelAndView mv = new ModelAndView();

		if(Database.search(id, pwd)) {
			System.out.println(Database.getName(id));
			mv.addObject("uname", Database.getName(id));
			mv.setViewName("welcome.jsp");
		}
		else {
			mv.setViewName("failure.jsp");
		}
		return mv;
	}
	
}
