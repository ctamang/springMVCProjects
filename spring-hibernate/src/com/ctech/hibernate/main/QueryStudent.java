package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Student;

public class QueryStudent {

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
			System.out.println(temp);
			session.save(temp);
			
			session.getTransaction().commit();
			
			
			//find out the student's primary key
			System.out.println("student saved, generated ID : " + temp.getId());
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			//retrieve student based on the id
			System.out.println("\ngetting student with id : " + temp.getId());
			
			Student myStudent = session.get(Student.class, temp.getId());
			
			System.out.println("get complete : " + myStudent);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			factory.close();
		}
	}

}
