package dchcobra.jpa10Steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import dchcobra.jpa10Steps.entity.User;

//access to database http://localhost:8080/h2-console

@Repository
@Transactional
public class UserDAOService {
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		entityManager.persist(user);
		return user.getId();
	}
}

/*
public class SomeEntityDAOService {
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(SomeEntity entity) {
		entityManager.persist(entity);
		return entity.getId();
	}
}
*/