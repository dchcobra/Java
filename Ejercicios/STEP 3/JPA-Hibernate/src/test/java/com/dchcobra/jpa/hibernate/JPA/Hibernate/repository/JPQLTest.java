package com.dchcobra.jpa.hibernate.JPA.Hibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dchcobra.jpa.hibernate.JPA.Hibernate.Application;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Course;

@SpringBootTest(classes=Application.class)
public class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_basic() {
		Query query = em.createQuery("SELECT c FROM Course c");
		List resultList = query.getResultList();
		logger.info("SELECT c FROM Course c -> {}", resultList);
		/* RESULT
		SELECT c FROM Course c -> [Course [id=1, name=Web Services in 100 Steps],
		                           Course [id=2, name=Angular Js in 100 Steps - Updated],
		                           Course [id=10001, name=JDBC to JPA], Course [id=10002,
		                           name=string], Course [id=10003, name=JPA]] */
	}
	
	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = 
				em.createQuery("SELECT c FROM Course c", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("SELECT c FROM Course c -> {}", resultList);
	}
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> query = 
				em.createQuery("SELECT c FROM Course c WHERE name LIKE '%100 Steps'", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("SELECT c FROM Course c -> {}", resultList);
	}
	
}
