package com.ctech.crm.service;

import java.util.List;

import com.ctech.crm.entity.Customer;
import com.ctech.crm.entity.Item;

public interface ItemService {

	List<Item> getItems();

	Item getItem(int theId);

	void saveItem(Item theItem);

	
}
