package com.in28minutes.database.databasedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28minutes.database.databasedemo.entity.Person;
import com.in28minutes.database.databasedemo.jpa.PersonJpaRepository;

import org.slf4j.LoggerFactory;

import java.util.Date;

import org.slf4j.Logger;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJpaRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("User id 10001 -> {}", repository.findById(10001));
		
		logger.info("Inserting 10004 -> {}",
				repository.insert(new Person(10004, "Tara", "Berlin", new Date())));
		
		logger.info("Inserting 10003 -> {}",
				repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
		 
		repository.deleteById(10002);

		logger.info("All users -> {}", repository.findAll());

	}

	

}
