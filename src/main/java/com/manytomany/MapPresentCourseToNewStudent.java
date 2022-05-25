package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class MapPresentCourseToNewStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Course course1  = entityManager.find(Course.class, 1);//HTML
		Course course2  = entityManager.find(Course.class, 2);//JAVA
		Course course3  = entityManager.find(Course.class, 3);//REACT
		
		List<Course> courses = new ArrayList<Course>() ;
		courses.add(course1) ;
		courses.add(course2) ;
		courses.add(course3) ;
		
		
		Student student = new Student() ;
		student.setName("chethan");
		student.setAge(28);
		student.setCourses(courses);
		
		entityTransaction.begin();

		entityManager.persist(student);
		
		entityTransaction.commit();

	}

}
