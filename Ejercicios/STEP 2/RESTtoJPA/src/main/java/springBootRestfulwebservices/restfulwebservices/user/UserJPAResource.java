package springBootRestfulwebservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.*;
import org.springframework.hateoas.EntityModel;





@RestController
public class UserJPAResource {
	//retrieve = recuperar
	@Autowired
	private UserDaoService service;
	
	@Autowired
	private UserRepository userRepository;
	
	//give all users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	/*
	@GetMapping("/jpa/users/{id}")
	public User retreveUser(@PathVariable int id) {
		userRepository.findById(id);
		if (userRepository == null) 
			throw new UserNotFoundException("id-" + id);		
		return (User) userRepository;
	}
	*/

	/*give a user that you introduce a ID
	we change Resource = EntityModel and import 
	import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
	import org.springframework.hateoas.*;
	import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
	
	and constructor change method and now use EntityModel.of()
	*/
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if (!user.isPresent()) 
			throw new UserNotFoundException("id-" + id);
		
		EntityModel<User> resource = EntityModel.of(user.get());
		
		/*WebMvcLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));*/
		return resource;
	}

	//Create a user method POST
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		 
		User savedUser = userRepository.save(user);

		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	//Delete a user that you introduce a ID
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);	
	}
	
	
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrieveAllUsers(@PathVariable int id) {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		return userOptional.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPost(@PathVariable int id, @RequestBody Post post) {
		
		Optional<User> userOptional = userRepository.findById(id);
		
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}
		
		User user = userOptional.get();
				
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(post.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
}
