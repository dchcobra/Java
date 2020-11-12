
public class Animal {
	
	private String nameAnimal;
	
	//Constructor
	public Animal() {
		
	}
	
	public Animal (String name) {
		nameAnimal = name;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s] Name: %s\n"
				, getClass().getName()
				, nameAnimal);
	}
}
