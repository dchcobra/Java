import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Function;

import CustomObjects.Person;

public class FunctionalInterfaces {
	
	public static void main(String[] args){
		Function<Integer, String> getString = (Integer i) -> {
			return "You sent me " + i;
		};
		System.out.println(getString.apply(30));
		System.out.println(getString.apply(45));
		System.out.println(getString.apply(-30));
	
		Function<Object, String> myOTS = (o) -> {
			return String.format("You sent me : %s", o.toString());
		};
		
		System.out.println(myOTS.apply("Any object works!"));
		System.out.println(myOTS.apply(50));
		System.out.println(myOTS.apply(true));
		System.out.println(myOTS.apply(new Person("John", "Smith", 48)));
		
		Comparator<String> c = (a, b) -> a.compareTo(b);
		CommonPrinter.po.printConsole(c.compare("Mike", "Marty"));
		CommonPrinter.po.printConsole(c.compare("Dan", "David"));
		CommonPrinter.po.printConsole(c.compare("John", "Andrew"));

		String one = "John";
		String two = "Andrew";
		
		Comparator<String> quickCompare = (a, b) -> {
			System.out.println("You cana run any code you would like here!");
			System.out.println(String.format("%s vs. %s", a, b));
			return c.compare(a, b);
		};
		
		CommonPrinter.po.printConsole(quickCompare.compare("Mike", "Marty"));
		CommonPrinter.po.printConsole(quickCompare.compare("Dan", "David"));
		CommonPrinter.po.printConsole(quickCompare.compare("John", "Andrew"));
	}
}
