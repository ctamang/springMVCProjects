package com.ctech.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ctech.crm.entity.OrderDetail;
import com.ctech.crm.service.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/getOrderDetails")
	public String getOrderDetails(@RequestParam("orderId")int theId, Model theModel) {
		
		List<OrderDetail> orderDetails = orderService.getOrderDetails(theId);
		
		theModel.addAttribute("orderDetails", orderDetails);
		
		return "order_details";
		
	}
	
	@RequestMapping("/delete")
	public String deleteOrder(@RequestParam("orderId") int id) {
		
		orderService.deleteOrder(id);
		
		return "order_details";
		
	}

}
