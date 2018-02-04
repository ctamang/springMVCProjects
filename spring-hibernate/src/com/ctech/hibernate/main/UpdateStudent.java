package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Student;

public class UpdateStudent {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			int studentId = 1;
			session.beginTransaction();
			
			//retrieve student based on the id
			System.out.println("\ngetting student with id : " + studentId);
			
			Student myStudent = session.get(Student.class, studentId);
			
			System.out.println("update student");
			myStudent.setFirstName("deepac");
			session.getTransaction().commit();
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("updating email for all students");
			
			session.createQuery("update Student set email='hello@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			factory.close();
		}
	}

}
