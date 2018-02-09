package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Course;
import com.ctech.hibernate.entity.Instructor;
import com.ctech.hibernate.entity.InstructorDetail;

public class CreateInstructor {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			
			Instructor tempInstructor = new Instructor("vikas", "joni", "vikas@gmail.com");
			
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.vikas.com", "playing video game");
			
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			//use the session object to save the java object
			session.beginTransaction();
			
			System.out.println("saving instructor data");
			session.save(tempInstructor);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
