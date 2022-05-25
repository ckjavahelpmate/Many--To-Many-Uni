package com.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveCab {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas") ;
		EntityManager entityManager = entityManagerFactory.createEntityManager() ;
		EntityTransaction entityTransaction = entityManager.getTransaction() ;
		
		Person person1 = new Person() ;
		person1.setName("urmila");
		person1.setAge(21);
		person1.setEmail("uru@baaru.com");
		
		Person person2 = new Person() ;
		person2.setName("nalini");
		person2.setAge(20);
		person2.setEmail("nalli@kulli.com");
		
		Person person3 = new Person() ;
		person3.setName("kaveri");
		person3.setAge(21);
		person3.setEmail("kavu@hari.com");
		
		List<Person> persons = new ArrayList() ;
		persons.add(person1) ;
		persons.add(person2) ;
		persons.add(person3) ;
		
		Cab cab = new Cab() ;
		cab.setDriverName("DriverBabu");
		cab.setCost("Rs.15 per km");
		cab.setPersons(persons);
		
		entityTransaction.begin();
		
		entityManager.persist(person1);
		entityManager.persist(person2);
		entityManager.persist(person3);
		entityManager.persist(cab);
		
		entityTransaction.commit();
		

		
		
	}

}
