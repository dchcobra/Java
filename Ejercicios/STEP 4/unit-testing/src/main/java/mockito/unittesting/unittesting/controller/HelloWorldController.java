package mockito.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/* STEP 1 - CHAPTER 3 */
@RestController
public class HelloWorldController {

	@GetMapping("/hello-world")
	public String helloWorld( ) {
		return "Hello World";
	}
}
