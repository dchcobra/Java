
public class Animal {
	
	private String nameAnimal;
	private String breedAnimal;
	
	//Constructor
	public Animal() {
		
	}
	
	public Animal (String name, String breed) {
		nameAnimal = name;
		breedAnimal = breed;
	}
	
	public void setName(String value) {
		nameAnimal = value;
	}
	
	public String getName() {
		return nameAnimal;
	}
	
	public void setBreed(String value) {
		breedAnimal = value;
	}
	
	public String getBreed() {
		return breedAnimal;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s] Name: %s | Breed: %s\n\t"
				, getClass().getName()
				, getName()
				, getBreed());
	}
}
