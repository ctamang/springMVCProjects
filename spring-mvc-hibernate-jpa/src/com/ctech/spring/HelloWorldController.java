package com.ctech.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
		
	// need a controller method to process the HTML form

	@RequestMapping("/submitForm")
	public String submitForm() {
		return "helloworld";
	}
	
	//new controller method to read form data and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsPlay(HttpServletRequest request, Model model) {
		
		//read the request parameter from the html form
		String theName = request.getParameter("studentName");
		
		//convert data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Yo!.., " + theName.toUpperCase();
		
		//add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//convert data to all caps
		theName = theName.toUpperCase();
		
		//create the message
		String result = "Yo!.., " + theName.toUpperCase();
		
		//add message to the model
		model.addAttribute("message", result);

		return "helloworld";
	}
}

