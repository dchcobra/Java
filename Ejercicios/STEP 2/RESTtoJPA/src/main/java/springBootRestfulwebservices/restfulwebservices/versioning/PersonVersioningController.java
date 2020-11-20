package springBootRestfulwebservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("David Castilla");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name("David", "Castilla"));
	}
	
	//Call to input introducing http://localhost:8080/person/param?version=2 and modify number of version to see other persons
	@GetMapping(value="/person/param", params="version=1")
	public PersonV1 paramV1() {
		return new PersonV1("David Castilla");
	}
	
	@GetMapping(value="/person/param", params="version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name("David", "Castilla"));
	}
	
	//CALL TO INPUT VERSION OF /PERSON/PARAM/ introducing on http://localhost:8080/person/header with key X-API-VERSION value "number"
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("David Castilla");
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name("David", "Castilla"));
	}
	
	//
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("David Castilla");
	}
	
	@GetMapping(value="/person/produces", produces="application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name("David", "Castilla"));
	}
}
