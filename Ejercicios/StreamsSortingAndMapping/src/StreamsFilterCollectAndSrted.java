import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Utilities.StringGenerator;

public class StreamsFilterCollectAndSrted {

	public static void main(String[] args) {
		List<Integer> testList = StreamsSortingAndMapping.listGenerator(20);
		
		testList.stream().filter(x -> {
			System.out.println("Lazy Evaluating " + x + " for evenness");
			return x % 2 == 0;
		});
		System.out.println(StringGenerator.stars());
		
		Object[] evens = testList.stream().filter(x -> {
					System.out.println("Lazy Evaluating " + x + " for evenness");
					return x % 2 == 0;
				}).toArray();
		System.out.println(StringGenerator.stars());
		
		long numEvens = testList.stream().filter(x -> {
			return x % 2 == 0;
		}).count();
		System.out.println("There are [" + numEvens + "] even numbers in the testList!");		
		System.out.println(StringGenerator.stars());

		try {
			Integer[] realEvens = (Integer[]) testList.stream().filter(x -> {
				return x % 2 == 0;}).toArray();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		List<Integer> newTestList = Stream.of(1,2,3,4,5,6).collect(Collectors.toList());
		for (Integer i : newTestList) {
			System.out.println("List from stream ollect: " + i);
		}
		System.out.println(StringGenerator.stars());

		List<Integer> betterEvens = testList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
		
		for (Integer i : betterEvens) {
			System.out.println("better events: " + i);
		} 
		System.out.println(StringGenerator.stars()); //linea 68 video
	}
}
