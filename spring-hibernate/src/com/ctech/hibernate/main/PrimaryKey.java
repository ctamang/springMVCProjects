package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Student;

public class PrimaryKey {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the java object
			System.out.println("creating three new student object");

			Student student1 = new Student("deepak", "rawat", "deepak012@gmail.com");
			Student student2 = new Student("sanjay", "negi", "sanjay012@gmail.com");
			Student student3 = new Student("vikas", "joni", "vikas012@gmail.com");

			session.beginTransaction();

			System.out.println("saving the students");
			session.save(student1);
			session.save(student2);
			session.save(student3);

			session.getTransaction().commit();

			System.out.println("DONE!");

		} finally {
			factory.close();
		}
	}
}
