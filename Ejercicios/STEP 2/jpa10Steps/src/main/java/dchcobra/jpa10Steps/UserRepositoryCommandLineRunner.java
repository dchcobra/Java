package dchcobra.jpa10Steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dchcobra.jpa10Steps.entity.User;
import dchcobra.jpa10Steps.service.UserDAOService;
import dchcobra.jpa10Steps.service.UserRepository;

//access to database http://localhost:8080/h2-console

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jill", "Admin");
		userRepository.save(user);		
		log.info("New User is created : " + user); //New User is created : user [id=1, name=Jack, role=Admin]
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived : " + userWithIdOne); //

		List<User> users = userRepository.findAll();
		log.info("All users : " + users); //

	}

}
