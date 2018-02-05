package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Instructor;
import com.ctech.hibernate.entity.InstructorDetail;

public class Delete {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			
			//use the session object to save the java object
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			if(tempInstructor != null) {
				System.out.println("deleting " + tempInstructor);
				
				session.delete(tempInstructor);
			}
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			factory.close();
		}
	}

}
