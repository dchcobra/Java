package com.dchcobra.jpa.hibernate.JPA.Hibernate.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
//@Table(name="CourseDetails") STEP 16
@NamedQueries(value = {
		@NamedQuery(name="query_get_all_courses", query = "Select c From Course c"),
		@NamedQuery(name="query_get_100_Steps_courses", query = "Select c From Course c where name like '%100 Steps'")
})

public class Course {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany(mappedBy="course", fetch = FetchType.EAGER)
	private List<Review> reviews = new ArrayList<>();
	
	@ManyToMany(mappedBy="courses")
	private List<Student> students = new ArrayList<>();
	
	/* CHAPTER 5 - STEP 18*/
	@UpdateTimestamp //Hace el guardado de la fecha/tiempo cada vez que se actualiza la entidad 
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp //Hace el guardado de la fecha/tiempo de la primera vez que se guarda la entidad 
	private LocalDateTime createdDate;
	
	
	protected Course() {};
	
	public Course(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}
	
	public void removeReviews(Review review) {
		this.reviews.remove(review);
	}
	
	public void addstudent(Student student) {
		this.students.add(student);
	}
	
	public void removestudents(Student student) {
		this.students.remove(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}


}
