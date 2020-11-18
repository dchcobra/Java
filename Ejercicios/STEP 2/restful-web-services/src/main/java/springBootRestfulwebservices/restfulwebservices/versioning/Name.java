package springBootRestfulwebservices.restfulwebservices.versioning;

public class Name {
	private String firstName;
	private String lastname;
	
	public Name() {
		
	};
	
	public Name(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
}
