package com.dchcobra.jpa.hibernate.JPA.Hibernate.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class FullTimeEmployee extends Employee {
	protected FullTimeEmployee() {};
	
	public FullTimeEmployee(String name, BigDecimal salay) {
		super(name);
		this.salay = salay;
	}
	
	private BigDecimal salay;
}
