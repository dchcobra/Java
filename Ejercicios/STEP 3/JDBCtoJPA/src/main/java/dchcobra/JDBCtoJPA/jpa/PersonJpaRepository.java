package dchcobra.JDBCtoJPA.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dchcobra.JDBCtoJPA.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	//connect to the DB
	@PersistenceContext
	EntityManager entityManager;
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id);
	}
	
}
