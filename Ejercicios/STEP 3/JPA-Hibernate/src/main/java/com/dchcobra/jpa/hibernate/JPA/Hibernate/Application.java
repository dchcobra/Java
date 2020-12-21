package com.dchcobra.jpa.hibernate.JPA.Hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Course;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.repository.CourseRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Creamos la tabla courser 
		// Course course = repository.findById(10001L);
		 
		
		//logger.info("Course 10001 - {}", course);
		//repository.deleteById(10001L);
		//repository.save(new Course("Microservice in 100 Steps"));
		repository.playWithEntiyManager();
		
	}

}
