
public class Driver {

	public static void main(String[] args) {
		String[] words = new String[4];
		int [] numbers = new int[4];
		
		words [0] = "The";
		words [1] = "Infinite Skills";
		words [2] = "Animal System Version: ";
		
		numbers [0] = 3;
		numbers [1] = 9;
		numbers [2] = 6;
		
		Animal[] myPets = new Animal[4];
		Dog d = new Dog("Rocky", "Bully", true);
		Cat c = new Cat("Fluffy", "Persia", false);
				
		myPets[0] = d;
		myPets[1] = new Dog("Lola", "Pitbull", true);
		myPets[2] = c;
		myPets[3] = new Cat("Spot", "Siamese", false);
	
		for (Animal animal : myPets) {
			System.out.println(animal);
		}
		
		myPets[1].setBreed("Vizsla");
		
		((Dog)myPets[0]).setIsServiceAnimal(true);
		((Cat)myPets[2]).setIsDeclawed(true);
		
		for (Animal animal : myPets) {
			if (animal instanceof Dog) {
				Dog myPetDog = (Dog) animal;
				myPetDog.setIsServiceAnimal(false);
				System.out.println("Set " + animal.getName() + "'s value for is a service animal to false");
			} else if (animal instanceof Cat) {
				Cat myPetCat = (Cat)animal;
				myPetCat.setIsDeclawed(false);
				System.out.println("Set " + myPetCat.getName() + "'s value for is a service animal to false");
			}
			System.out.println(animal);
		}

	}

}
