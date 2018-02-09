package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Course;
import com.ctech.hibernate.entity.Instructor;
import com.ctech.hibernate.entity.InstructorDetail;

public class GetInstructorCourses {

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
			
			Instructor tempInstructor = session.get(Instructor.class, id);
			
			Course tempCourse1 = new Course("Guitar");
			Course tempCourse2 = new Course("singing");
			
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
