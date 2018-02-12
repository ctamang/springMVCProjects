package com.ctech.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ctech.crm.entity.Customer;
import com.ctech.crm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject customerService
	@Autowired
	CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from Service
		List<Customer> customers = customerService.getCustomers();
		
		//add customers to spring mvc model
		theModel.addAttribute("customers", customers);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int theId,
											Model theModel){
		
		//getting the customer from the database
		Customer theCustomer = customerService.getCustomer(theId);
		
		//set customer as model attribute to pre-populate the data on the customer page
		theModel.addAttribute("customer", theCustomer);
		
		//send over to our form
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId")int theId) {
		
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
	
	
	
	
	
}







