package com.dchcobra.jpa.hibernate.JPA.Hibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Course;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Passport;
import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Student;


@Repository
@Transactional
public class StudentRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	public Student findById(Long id) {
		return em.find(Student.class, id);
	};
	
	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	};
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		em.persist(passport);

		Student student = new Student("Mike");
		student.setPassport(passport);
		em.persist(student);
	};
	
	public void someOperationToUnderstandPesistenceContext() {
		Student student = em.find(Student.class, 20001L);
		
		Passport passport = student.getPassport();
		
		passport.setNumber("E123456");

		student.setName("Ranga - updated");
	}
	
	public void insertHardcodedStudentAndCourse() {
		Student student = new Student("Jack");
		Course course = new Course("Microservices in 100 steps");
		em.persist(course);
		em.persist(student);
		
		student.addCourses(course);
		course.addstudent(student);
		
		em.persist(student);
	}
	
	public void insertStudentAndCourse(Student student, Course course) {
		em.persist(course);
		em.persist(student);
		
		em.persist(student);
	}
}
