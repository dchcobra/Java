
public class Driver {

	public static void main(String[] args) {
		Animal a = new Animal();
		System.out.println(a);
		Animal b = new Animal("Rocky", "Dog");
		System.out.println(b);
		Animal c = new Animal("Fizz", "Fish");
		System.out.println(c);
		
		Dog d = new Dog("Rocky", "Dog", false);
		System.out.println(d);
		
		Cat e = new Cat("Fluffy", "Cat", true);
		System.out.println(e);
	}

}
