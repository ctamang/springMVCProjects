package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Instructor;
import com.ctech.hibernate.entity.InstructorDetail;

public class GetInstructorDetail {

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
			
			int theId = 3;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("tempInstructorDetail : " + tempInstructorDetail);
			
			System.out.println("the associated instructor : " + tempInstructorDetail.getInstructor());
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		catch(Exception e) {
				e.printStackTrace();
		}
		finally {
			//handle connection leak issue
			session.close();
			
			factory.close();
		}
	}

}
