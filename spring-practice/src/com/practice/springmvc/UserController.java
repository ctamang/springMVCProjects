package com.practice.springmvc;

import java.util.LinkedHashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@Value("#{countryOptions}")
	private LinkedHashMap<String, String> countryOptions;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		
	}
	
	@RequestMapping("/register")
	public String DisplayUserRegistrationPage(Model theModel) {
		populateRefValues(theModel);
		theModel.addAttribute("user", new User());
		return "registration-page";
	}
	
	void populateRefValues(Model theModel){
		theModel.addAttribute("theCountryOptions", countryOptions);
	}
	
	@RequestMapping("/submitRegistrationDeatails")
	public String processUserDetails(@Valid @ModelAttribute("user") User theUser, BindingResult theBindingResult, Model theModel) {
		
		System.out.println("name || " + theUser.getName());
		System.out.println("binding result || " + theBindingResult);
		if(theBindingResult.hasErrors()) {
			populateRefValues(theModel);
			return "registration-page";
		}
		else {
			return "user-details-page";
		}
	}
	
}
