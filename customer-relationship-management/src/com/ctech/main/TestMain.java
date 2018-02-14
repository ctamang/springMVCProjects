package com.ctech.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.crm.entity.Customer;
import com.ctech.crm.entity.Order;


public class TestMain {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Order.class)
								.addAnnotatedClass(Customer.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			session.beginTransaction();
			
			int id = 5;
			
			Customer tempCustomer = session.get(Customer.class, id);
			
			System.out.println("Customer : " + tempCustomer );
			
			System.out.println("Orders : " + tempCustomer.getOrders());
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
