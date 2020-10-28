import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;

import org.graalvm.compiler.graph.spi.Canonicalizable.Binary;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
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
		
		if (c.compare(one, two) > 0 ) {
			CommonPrinter.po.printConsole(one + " is greater than " + two + "!");
		} else {
			CommonPrinter.po.printConsole(two + " is greater than " + one + "!");
		}
		
		BiFunction<String, String, String> compareTwoStrings = (o, t) -> {
			String output = "%s is greater than %s";
			return (c.compare(o, t) > 0
					? String.format(output, o, t)
					: String.format(output, t, o) );
		};
		System.out.println(compareTwoStrings.apply(one, two));
		two = "Zeta";
		System.out.println(compareTwoStrings.apply(one, two));
		
		BinaryOperator<Integer> a = (Integer x, Integer y) -> x + y;
		System.out.println("Add 3 + 2: " + a.apply(3, 2));
		System.out.println("Add 7 + 10: " + a.apply(7, 10));
		
		BinaryOperator<Double> dbo = (x, y) -> x / y;
		System.out.println(dbo.apply(8.0, 2.0));
		System.out.println(dbo.apply(8.0, 0.0));
		
		Predicate<String> containsValue = (String v) -> v.toLowerCase().contains("value");
		System.out.println("What contains Value? " + containsValue.test("What?"));
		System.out.println("Value contains Value? " + containsValue.test("Value?"));
		
		Predicate<Integer> isEven = (x) -> x % 2 == 0;
		System.out.println("32? " + isEven.test(32));
		System.out.println("55? " + isEven.test(55));
		
		List<Integer> productIDs = new ArrayList<Integer>();
		Random r = new Random(48915);
		for (int i = 0; i < 50; i++) {
			productIDs.add(r.nextInt(999999));
		}
		
		List <Integer> filteredIDs = filterList(isEven, productIDs);
		for (Integer i : filteredIDs) {
			System.out.println("Next Value: " + i);
		}
	}
		public static <T> List<T> filterList(Predicate<T> p, List<T> items) {
			List<T> result = new ArrayList<T>();
			for (T data : items) {
				if (p.test(data)) {
					result.add(data);
				}
		}
		return result;
	}
}
