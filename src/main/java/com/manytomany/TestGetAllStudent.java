package com.manytomany;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestGetAllStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;

		Query query = entityManager.createQuery("select s from Student s") ;

		List<Student> students = query.getResultList() ;

		if( students != null ) {
			for(Student  student : students ) {

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

		}
		else {
			System.out.println("No students found");
		}


	}

}
