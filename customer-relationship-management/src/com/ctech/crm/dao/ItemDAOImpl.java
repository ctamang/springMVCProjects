package com.ctech.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctech.crm.entity.Customer;
import com.ctech.crm.entity.Item;

@Repository
public class ItemDAOImpl implements ItemDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Item> getItems() {
		
		Session currentSession = sessionFactory.getCurrentSession();	
		
		Query<Item> theQuery = currentSession.createQuery("from Item order by itemName", Item.class);
		
		List<Item> items = theQuery.getResultList();
		
		return items;
	}

	@Override
	public Item getItem(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Item item = currentSession.get(Item.class, id);
		
		return item;
	}

	@Override
	public void saveItem(Item theItem) {

		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theItem);
	}

	

}
