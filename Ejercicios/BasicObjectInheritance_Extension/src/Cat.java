
public class Cat extends Animal{
	private boolean isDeclawed1;
	
	//Constructor
	public Cat() {
		super();
	}
	
	public Cat(String name, String breed, boolean isDeclawed) {
		super(name, breed);
		isDeclawed1 = isDeclawed;
	}
	
	public String toString() {
		return String.format("%s\t Is declawed: %b\n"
								, super.toString()
								, isDeclawed1 );
	}
	
}
