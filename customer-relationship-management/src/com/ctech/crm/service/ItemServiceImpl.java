package com.ctech.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctech.crm.dao.ItemDAO;
import com.ctech.crm.entity.Item;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO;
	
	@Override
	@Transactional
	public List<Item> getItems() {
		
		return itemDAO.getItems();
	}

	@Override
	@Transactional
	public Item getItem(int theId) {
		
		return itemDAO.getItem(theId);
	}

	@Override
	@Transactional
	public void saveItem(Item theItem) {
		
		itemDAO.saveItem(theItem);
	}

}
