package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Instructor;
import com.ctech.hibernate.entity.InstructorDetail;

public class Create {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			
			Instructor tempInstructor = new Instructor("deepak", "rawat", "deepak025@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.deepak.com", "reading");
			
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			//use the session object to save the java object
			session.beginTransaction();
			
			System.out.println("saving instructor data");
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			factory.close();
		}
	}

}
