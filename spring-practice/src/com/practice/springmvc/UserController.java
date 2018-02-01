package com.practice.springmvc;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Value("#{countryOptions}")
	private LinkedHashMap<String, String> countryOptions;
	
	@RequestMapping("/register")
	public String DisplayUserRegistrationPage(Model theModel) {
		
		theModel.addAttribute("user", new User());
		theModel.addAttribute("theCountryOptions", countryOptions);
		return "registration-page";
	}
	
	
	@RequestMapping("/submitRegistrationDeatails")
	public String displayUserDetailsPage(@ModelAttribute("user") User theUser) {
		return "user-details-page";
	}
	
}
