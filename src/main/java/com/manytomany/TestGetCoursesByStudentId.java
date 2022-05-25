package com.manytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetCoursesByStudentId {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;

		Student student = entityManager.find(Student.class, 4 ) ;

		if( student != null ) {
			List<Course> courses = student.getCourses() ;
			
			System.out.println("Student Id: "+student.getId());
			System.out.println("Student name: "+student.getName());
			System.out.println("Student age: "+student.getAge());
			
			for(Course course : courses  ) {
				System.out.println("**************************************");
				System.out.println("Course id: "+course.getId());
				System.out.println("Course name: "+course.getName());
				System.out.println("Course duration: "+course.getDuration());
				System.out.println("**************************************");
			}
		}
		else {
			System.out.println("No student found for given id");
		}
	}

}
