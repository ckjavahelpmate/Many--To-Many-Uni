package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveStudent {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Course course1  = new Course() ;
		course1.setName("HTML");
		course1.setDuration("10 days");
		
		Course course2  = new Course() ;
		course2.setName("JAVA");
		course2.setDuration("40 days");
		
		Course course3  = new Course() ;
		course3.setName("REACT");
		course3.setDuration("30 days");
		
		List<Course> courses = new ArrayList<Course>() ;
		courses.add(course1) ;
		courses.add(course2) ;
		courses.add(course3) ;
		
		
		Student student = new Student() ;
		student.setName("nalini");
		student.setAge(23);
		student.setCourses(courses);
		
		entityTransaction.begin();
		
		entityManager.persist(course1);
		entityManager.persist(course2);
		entityManager.persist(course3);
		entityManager.persist(student);
		
		entityTransaction.commit();

	}

}
