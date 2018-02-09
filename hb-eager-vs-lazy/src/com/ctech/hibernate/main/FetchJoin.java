package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.ctech.hibernate.entity.Course;
import com.ctech.hibernate.entity.Instructor;
import com.ctech.hibernate.entity.InstructorDetail;

public class FetchJoin {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			//use the session object to save the java object
			session.beginTransaction();
			
			int id =1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
															+ "JOIN FETCH i.courses "
															+ "where i.id=:theInstructorId",
															Instructor.class);
			
			query.setParameter("theInstructorId", id);
			
			Instructor tempInstructor = new Instructor();
			
			tempInstructor = query.getSingleResult();
			
			System.out.println("Instructor details : " + tempInstructor);
			
			session.getTransaction().commit();
			
			session.close();
			
			System.out.println("Courses : " + tempInstructor.getCourse());
			
			System.out.println("DONE!");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
