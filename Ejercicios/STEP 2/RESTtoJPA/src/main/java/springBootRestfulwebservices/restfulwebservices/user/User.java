package springBootRestfulwebservices.restfulwebservices.user;

// @ApiModel Allow print annotations on the http://localhost:8080/v2/api-docs

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

//http://localhost:8080/h2-console/ access the db

@ApiModel(description="All detauls about the user. ")
@Entity
public class User {
	/* message = text when return error
	 Referencia to javax.validation, you can see on pom.xml 
	 and use @valid when you create a user
	 */
	@Id
	@GeneratedValue
	@ApiModelProperty(notes="ID Auto-Generated ")
	private Integer id;
	
	@Size(min=2, message="Name contains min 2 character")
	@ApiModelProperty(notes="Name contains min 2 character")
	private String name;
	// Validate date introduce user, can't introduce date future
	@Past(message="Birth date should be in the past")
	@ApiModelProperty(notes="Birth date should be in the past")
	private Date birthData;
	
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
