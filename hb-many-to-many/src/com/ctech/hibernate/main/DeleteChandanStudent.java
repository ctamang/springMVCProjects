package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Course;
import com.ctech.hibernate.entity.Instructor;
import com.ctech.hibernate.entity.InstructorDetail;
import com.ctech.hibernate.entity.Review;
import com.ctech.hibernate.entity.Student;

public class DeleteChandanStudent {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Student.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession(); 
		
		try {
			session.beginTransaction();
			
			int studentId = 3;

			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("Deleting course" + tempStudent);
			//System.out.println(tempStudent.getCourses());
			
			session.delete(tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
