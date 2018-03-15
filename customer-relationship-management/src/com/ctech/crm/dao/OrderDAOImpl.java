package com.ctech.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ctech.crm.entity.Customer;
import com.ctech.crm.entity.Item;
import com.ctech.crm.entity.Order;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Order> getOrders(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> query = currentSession.createQuery("select i from Customer i "
				+ "JOIN FETCH i.orders "
				+ "where i.id=:theCustomerId",
				Customer.class);
		
		query.setParameter("theCustomerId", id);
		
		Customer theCustomer = query.getResultList().stream().findFirst().orElse(null);
		
		if(theCustomer == null) {
			return null;
		}

		return theCustomer.getOrders();
		
	}

	@Override
	public List<Item> getOrderDetails(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Order theOrder = currentSession.get(Order.class, id);
		
		return theOrder.getItems();
		
	}

	@Override
	public void deleteOrder(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Order theOrder = currentSession.get(Order.class, id);
		
		currentSession.delete(theOrder);
	}
	

}
