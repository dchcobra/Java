
public class Dog extends Animal {
	private boolean isServiceAnimal;
	
	
	//Constructor
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public boolean getIsServiceAnimal( ) {
		return isServiceAnimal;
	}
	
	public void setIsServiceAnimal (boolean isServiceAnimal1) {
		isServiceAnimal = isServiceAnimal1;
	}
	
	public Dog(String name, String breed, boolean isServiceAnimal1) {
		super(name, breed);
		isServiceAnimal = isServiceAnimal1;
	}
	
	
	public String toString() {
		return String.format("%s\t Is service: %b\n"
								, super.toString()
								, isServiceAnimal );
	}

}
