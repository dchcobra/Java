package springBootRestfulwebservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.*;

@RestController //Make to app see this file
public class HelloWorldController {
	/*
	 * GET
	 * URL - /hello-world
	 * method - "heloWorld"
	 */
	
	//1º method to return Hello World
	/*
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	*/
	//2º method to return Hello World
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	//Pass the var (David) to the path (hello-world-bean/path-variable/David) to show "Hello World, David"
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
}
