package com.ctech.crm.dao;

import java.util.List;

import com.ctech.crm.entity.Customer;
import com.ctech.crm.entity.Item;

public interface ItemDAO {

	public List<Item> getItems();

	public Item getItem(int id);

	public void saveItem(Item theItem);

}
