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

import com.ctech.crm.entity.Item;
import com.ctech.crm.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@GetMapping("/list")
	public String getItemList(Model theModel) {
		
		List<Item> items = itemService.getItems();
		
		theModel.addAttribute("items", items);
		return "list-item";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("itemId")int theId,
											Model theModel){
		
		//getting the item from the database
		Item theItem = itemService.getItem(theId);
		
		//set item as model attribute to pre-populate the data on the item page
		theModel.addAttribute("item", theItem);
		
		//send over to our form
		
		return "item-form";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){
		
		Item theItem = new Item();
		
		theModel.addAttribute("item", theItem);
		
		return "item-form";
	}
	
	@PostMapping("/saveItem")
	public String saveItem(@ModelAttribute("item") Item theItem) {
		
		itemService.saveItem(theItem);
		return "redirect:/item/list";
	}
	
	
	
	
}
