package com.ctech.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.ctech.crm.entity.Order;

public class OrderDAOImpl implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Order> getOrders(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Order> theQuery = currentSession.createQuery("from Order where customer_Id:=customerId", Order.class);
		
		theQuery.setParameter("customerId", id);
		
		return theQuery.getResultList();
	}

}
