import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import Utilities.StringGenerator;
import CustomObjects.Person;

public class StreamsSortingAndMapping {
	
	public static void main(String[] args) {
		List<Person> newEmps = null;
		
		System.out.println(StringGenerator.stars());
		System.out.println("DEFAULT EMPLOYEES: ");
		List<Person> myEmployees = StreamsSortingAndMapping.getEmployees();
		myEmployees.forEach(e -> System.out.println("Next Employee: " + e));
		System.out.println(StringGenerator.stars());
		
		System.out.println("Sorted Employees with Comparator on Last Name");
		Comparator<Person> personComparator = (Person a, Person b) -> {return a.getLastName().compareTo(b.getLastName());};
		Collections.sort(myEmployees, personComparator);
		myEmployees.forEach(e -> System.out.println("Next Emp by Last Name: " + e));
		System.out.println(StringGenerator.stars());
		
		personComparator = (a, b) -> {
			return ((Integer)a.getAge()).compareTo((Integer)b.getAge());
		};
		newEmps = myEmployees.stream().sorted(personComparator).collect(Collectors.toList());
		newEmps.forEach(e -> System.out.println("Emps by Age: " + e));
		System.out.println(StringGenerator.stars());
		
		System.out.println(StringGenerator.stars());
		System.out.println("Sorted Employees with Comparator on Age and Filter > 25");
		
		newEmps = myEmployees.stream().filter(x -> x.getAge() > 25).sorted(personComparator).collect(Collectors.toList());
		newEmps.forEach(e -> System.out.println("Emps by Age: " + e));		
		System.out.println(StringGenerator.stars());
		
		newEmps = StreamsSortingAndMapping.getEmployees();
		List<String> empsOver25 = newEmps.stream().filter(x -> x.getAge() > 25)
				.map(x -> x.getFirstName() + " " + x.getLastName() + " : " + x.getAge() + " years old")
				.collect(Collectors.toList());
		
		empsOver25.forEach(e -> System.out.println(e));
		System.out.println(StringGenerator.stars());
		
		
		Function<Person, String> personReport = (a) -> {return a.getLastName() + ", " + a.getFirstName() + ": " + a.getAge();};
		List<String> empsOver40 = newEmps.stream().filter(x -> x.getAge() > 40)
				.sorted(personComparator).map(personReport).collect(Collectors.toList());
		empsOver40.forEach(e -> System.out.println(e));
		System.out.println(StringGenerator.stars());
		
		List<Person> people = StreamsSortingAndMapping.getPeople(20);
		List<Integer> ageList = people.stream().map(Person::getAge).collect(Collectors.toList());
		ageList.stream().sorted().collect(Collectors.toList()).forEach(x -> System.out.println("Next Age: " + x));
		System.out.println(StringGenerator.stars());
		
		personComparator = (Person a, Person b) -> { return a.getFirstName().compareTo(b.getFirstName()); };
		List<String> nameList = people.stream().sorted(personComparator).map(Person :: getFirstName).collect(Collectors.toList());
		nameList.forEach(x -> System.out.println("Next Name: " + x));
		System.out.println(StringGenerator.stars());
		

		double average = people.stream().filter(x -> x.getAge() > 25)
										.mapToInt(Person::getAge)
										.average()
										.getAsDouble();
		System.out.println("Average age of employees over 25 is: " + average);
		
		System.out.println(StringGenerator.stars());
		
		Map<Integer, List<Person>> empsByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));
		empsByAge.forEach((k,v) -> System.out.println(StringGenerator.stars() + "\nAge: " + k + "\nName:\n" + v));
		System.out.println(StringGenerator.stars());
		
		System.out.println("My employees that are age 25: " + empsByAge.get(25));
		System.out.println(StringGenerator.stars());
	}
	
	
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
