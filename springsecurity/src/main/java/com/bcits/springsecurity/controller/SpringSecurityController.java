package com.bcits.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SpringSecurityController {
	
	@GetMapping("/index")
	public String getIndexPage() {
		
		return "index";
	}
	
	@GetMapping("/adminSecureHome")
	public String getAdminHomePage() {
		
		return "adminHomePage";
	}
	@GetMapping("/userSecureHome")
	public String getUserHomePage() {
		
		return "userHomePage";
	}
	
	@GetMapping("/login")
	public String getLoginForm() {
		
		return "loginForm";
	}
  
	
}
