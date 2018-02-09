package com.ctech.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ctech.hibernate.entity.Course;
import com.ctech.hibernate.entity.Instructor;
import com.ctech.hibernate.entity.InstructorDetail;
import com.ctech.hibernate.entity.Review;
import com.ctech.hibernate.entity.Student;

public class CreateCourseAndStudents {

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
			
			Course tempCourse = new Course("Artificial Intelligence Course");
			
			Student tempStudent1 = new Student("chandan", "tamang", "chandan@gmail.com");
			Student tempStudent2 = new Student("deepak", "rawat", "deepak@gmail.com");
			
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			session.save(tempCourse);
			session.save(tempStudent1);
			session.save(tempStudent2);
			
			session.getTransaction().commit();
			
			System.out.println("DONE!");
			
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
