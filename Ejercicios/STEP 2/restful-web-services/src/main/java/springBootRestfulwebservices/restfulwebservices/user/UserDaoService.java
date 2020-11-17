package springBootRestfulwebservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	//Make users and save on list
	static {
		users.add(new User(1, "Adri", new Date()));
		users.add(new User(2, "Evelynn", new Date()));
		users.add(new User(3, "Jacobo", new Date()));
	}
	//Method to find all users and return
	public List<User> findAll() {
		return users;
	}
	//Save a new user on list
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++ usersCount);
		}
		users.add(user);
		return user;
	}
	//Find a user into the list of all users
	public User findOne(int id) {
		for (User user:users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	//Delete user of the list of all users
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
}