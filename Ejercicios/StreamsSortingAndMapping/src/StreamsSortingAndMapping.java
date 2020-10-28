import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import Utilities.StringGenerator;
import CustomObjects.Person;

public class StreamsSortingAndMapping {
	public static List<Integer> listGenerator(int num) {
		List <Integer> retList = new ArrayList <Integer>();
		Random r = new Random();
		int range = 900000;
		for (int i = 0; i < num; i++) {
			retList.add(r.nextInt(range) + 100000);
		}		
		return retList;
	}
	
	public static List<Person> getPeople(int num) {
		List<Person> p = new LinkedList<Person>();
		Random r = new Random();
		for (int i = 0; i < num; i++) {
			p.add(new Person(StringGenerator.generateRandomString(-1) 
					, StringGenerator.generateRandomString(-1)
					, r.nextInt(99) + 1));
		}
		return p;
	}
	
	public static List<Person> getEmployees() {
		List<Person> p = new LinkedList<Person>();
		
		p.add(new Person("John", "Smith", 38));
		p.add(new Person("Mike", "Collins", 53));
		p.add(new Person("Tara", "DeForrest", 43));
		p.add(new Person("Angela", "McMahon", 25));
		p.add(new Person("Donald", "Paulus", 25));
		p.add(new Person("Ralph", "Johnson", 18));
		p.add(new Person("Peter", "Jones", 64));
		p.add(new Person("Sally", "Smith", 45));
		p.add(new Person("Paula", "Franklin", 45));
		p.add(new Person("Amy", "Jacobs", 47));
		return p;
	}
	
}
