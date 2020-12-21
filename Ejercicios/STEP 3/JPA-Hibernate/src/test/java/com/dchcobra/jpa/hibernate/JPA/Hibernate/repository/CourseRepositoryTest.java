package com.dchcobra.jpa.hibernate.JPA.Hibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Course;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.Application;

@SpringBootTest(classes=Application.class)
public class CourseRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Test
	public void findById_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JDBC to JPA", course.getName());
	}
	
	@Test
	@DirtiesContext
	public void deleteById_basic() {
		repository.findById(10001L);
		assertNull(repository.findById(10001L));
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = repository.findById(10001L);
		assertEquals("JDBC to JPA", course.getName());
		
		course.setName("JDBC to JPA updated");
		
		repository.save(course);
		
		Course course1 = repository.findById(10001L);
		assertEquals("JDBC to JPA updated", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntiyManager() {
		repository.playWithEntiyManager();
	}
}
