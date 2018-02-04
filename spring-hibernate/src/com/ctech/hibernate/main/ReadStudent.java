package com.ctech.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Student;

public class ReadStudent {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {

			session.beginTransaction();
			
			//Query the students
			List<Student> theStudent = session.createQuery("from Student").list();
		
			//display the students
			displayStudent(theStudent);
			
			//query student : lastName = 'tamang'
			theStudent = session.createQuery("from Student s where s.lastName='tamang'").getResultList();
			
			//display the students
			System.out.println("\n\ndisplay students lastName = 'tamang'");
			displayStudent(theStudent);
			
			//query student : lastName = 'tamang'
			theStudent = session.createQuery("from Student s where"
											+ " s.lastName='tamang' OR s.firstName='deepak'").getResultList();
			
			//display the students
			System.out.println("\n\ndisplay students lastName = 'tamang' or firstName='deepak'");
			displayStudent(theStudent);
			
			//query student : email = ends with 'gmail.com''
			theStudent = session.createQuery("from Student s where"
											+ " s.email LIKE '%gmail.com'").getResultList();
			
			//display the students
			System.out.println("\n\ndisplay students email ends with 'gmail.com'");
			displayStudent(theStudent);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudent) {
		for(Student student : theStudent)
		{
			System.out.println(student);
		}
	}

}
