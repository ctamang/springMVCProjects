package com.practice.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

	
	@RequestMapping("/login")
	public String processLoginPage(Model theModel) {
		
		theModel.addAttribute("login", new Login());
		return "login";
	}
	
	@RequestMapping("/processLoginPage")
	public String processLoginPage(@ModelAttribute("user") User theUser) {
		
		return "user-details-page";
	}
}
