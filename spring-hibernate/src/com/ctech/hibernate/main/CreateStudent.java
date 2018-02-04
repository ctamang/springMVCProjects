package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Student;

public class CreateStudent {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			//use the session object to save the java object
			System.out.println("creating a new student object");
			
			Student temp = new Student("chandan", "tamang", "ctamang025@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("saving the student");
			session.save(temp);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			factory.close();
		}
	}

}
