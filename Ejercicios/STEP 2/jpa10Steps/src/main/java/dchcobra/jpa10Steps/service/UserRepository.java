package dchcobra.jpa10Steps.service;

import org.springframework.data.jpa.repository.JpaRepository;
import dchcobra.jpa10Steps.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
}
