package springBootRestfulwebservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;

@RestController
public class UserResource {
	//retrieve = recuperar
	@Autowired
	private UserDaoService service;
	
	//give all users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}
	//give a user that you introduce a ID
	@GetMapping("/users/{id}")
	public User retreveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (user == null) 
			throw new UserNotFoundException("id-" + id);		
		return user;
	}
	//Create a user method POST
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		 
		 User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	//Delete a user that you introduce a ID
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		if (user == null) 
			throw new UserNotFoundException("id-" + id);		
	}
}
