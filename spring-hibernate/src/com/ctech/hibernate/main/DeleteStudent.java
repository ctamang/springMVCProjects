package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Student;

public class DeleteStudent {

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
			
			//Student myStudent = session.get(Student.class, studentId);
			
			//session.delete(myStudent);
			
			session.createQuery("delete from Student where id=2").executeUpdate();
			//session.createQuery("update Student set email='hello@gmail.com'").executeUpdate();
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			factory.close();
		}
	}

}
