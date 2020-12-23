package com.dchcobra.jpa.hibernate.JPA.Hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Course;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.FullTimeEmployee;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.PartTimeEmployee;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Review;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Student;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.repository.CourseRepository;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.repository.EmployeeRepository;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.repository.StudentRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
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
		//repository.playWithEntiyManager();
		//studentRepository.saveStudentWithPassport();
		//courseRepository.addHardcodedReviewsForCourse();
		
		/* STEP 33 - CHAPTER 8 
		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5", "Great Hands-on Stuff"));
		reviews.add(new Review("5", "Hatsoff"));
	
		courseRepository.addReviewsForCourse(10003L, reviews);*/
		
		//studentRepository.insertHardcodedStudentAndCourse();
		//studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 steps"));
		/* CHAPTER 9
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("Part Time Employees {}", employeeRepository.retrieveAllPartTimeEmployees());
		logger.info("Full Time Employees {}", employeeRepository.retrieveAllFullTimeEmployees());*/
	}

}
