package dchcobra.jpa10Steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import dchcobra.jpa10Steps.entity.User;


@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

	@Autowired
	private UserDaoService userDaoService;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Jack", "Admin");
		long insert = userDaoService.insert(user);
	}

}
