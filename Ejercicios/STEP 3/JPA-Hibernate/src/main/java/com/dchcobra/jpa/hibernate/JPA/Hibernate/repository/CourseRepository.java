package com.dchcobra.jpa.hibernate.JPA.Hibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dchcobra.jpa.hibernate.JPA.Hibernate.entity.Course;


@Repository
@Transactional
public class CourseRepository {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	};
	
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	};
	
	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}
		
		return course;
	};
	//clear and detach
	/*public void playWithEntiyManager() {
		Course course = new Course ("Web Services in 100 Steps");
		em.persist(course);
		em.flush();
		
		

		Course course2 = new Course ("Angular Js in 100 Steps");
		em.persist(course2);
		em.flush();

		//em.detach(course2); hace que no se ejecute lo siguiente que tenga referencia a el
		
		//em.clear(); limpia el siguiente codigo
		
		course.setName("Web Services in 100 Steps - Updated");
		em.flush(); // Hace que requiera que se guarden los datos
		
		course2.setName("Angular Js in 100 Steps - Updated");
		em.flush();

	}*/
	
	public void playWithEntiyManager() {
		Course course = new Course ("Web Services in 100 Steps");
		em.persist(course);
		Course course2 = new Course ("Angular Js in 100 Steps");
		em.persist(course2);
		em.flush();
		
		course.setName("Web Services in 100 Steps - Updated");
		course2.setName("Angular Js in 100 Steps - Updated");
		
		em.refresh(course);

	}
	
}
