package com.ctech.crm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ctech.crm.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the session factory
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		
		//get the current hibernate sesssion
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*//create a query
		Query<Customer> theQuery = currentSession.createQuery("from Customer", Customer.class);
		
		//get the result of qury
		List<Customer> customers = theQuery.getResultList();*/
		
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = theQuery.getResultList();
		
		//return the result		
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();	
		
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		
		Session crrentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = crrentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
	}

}
