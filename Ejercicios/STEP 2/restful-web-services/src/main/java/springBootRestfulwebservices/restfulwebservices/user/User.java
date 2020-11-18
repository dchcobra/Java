package springBootRestfulwebservices.restfulwebservices.user;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


public class User {
	/* message = text when return error
	 Referencia to javax.validation, you can see on pom.xml 
	 and use @valid when you create a user
	 */
	@Size(min=2, message="El nombre ha de tener almenos 2 caracteres")
	private String name;
	// Validate date introduce user, can't introduce date future
	@Past(message="La fecha ha de ser igual o anterior a la actual")
	private Date birthData;
	private Integer id;
	
	protected User() {
		
	}
		
	public User(Integer id, String name, Date birthData) {
		super();
		this.id = id;
		this.name = name;
		this.birthData = birthData;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getBirthData() {
		return birthData;
	}
	
	public void setBirthData(Date birthData) {
		this.birthData = birthData;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthData=" + birthData + "]";
	}
	
	
	
}
