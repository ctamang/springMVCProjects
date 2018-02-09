package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Course;
import com.ctech.hibernate.entity.Instructor;
import com.ctech.hibernate.entity.InstructorDetail;
import com.ctech.hibernate.entity.Review;

public class CreateCourseAndReviews {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			session.beginTransaction();
			
			Course tempCourse = new Course("AI");
			
			tempCourse.addReviews(new Review("greate course"));
			tempCourse.addReviews(new Review("nice"));
			tempCourse.addReviews(new Review("loved it"));
			
			session.save(tempCourse);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
