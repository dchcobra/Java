import java.util.*;

public class StringOperations {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please insert any verb");
		String aString = input.nextLine();
		String anotherString = "to the store!";
		
		for (int i = 0; i < aString.length(); i++) {
			System.out.println(i + "] " + aString.charAt(i));
		}
		
		System.out.println(aString + " compared to ZZZZ; ");
		System.out.println(aString.compareTo("ZZZZ"));
		System.out.println("ZZZZ compared to " + aString + ": ");
		System.out.println("ZZZZ".compareTo(aString));
		
		System.out.println(aString + "compared to AAAA: ");
		System.out.println(aString.compareTo("AAAA"));
		System.out.println("AAAA compared to " + aString + ": ");
		System.out.println("AAAA".compareTo(aString));
		
		System.out.println(aString + " compared to " + aString + ": ");
		System.out.println(aString.compareTo(aString));
		
		System.out.println(aString + "concatenated to " + anotherString);
		System.out.println(aString.concat(anotherString));
		
		System.out.println("Does " + aString + " contain any letter r's? ");
		if (aString.contains("r")) {
			System.out.println("Yes!");
		} else {
			System.out.println("NO!");
		}
		System.out.println("Does " + aString + " contain 'wal' ? ");
		if (aString.contains("wall")) {
			System.out.println("Yes!");
		} else {
			System.out.println("NO!");
		}
		
		System.out.println("Does " + aString + " equals " + anotherString);
		System.out.println(aString.equals(anotherString));
		System.out.println(aString.equalsIgnoreCase(anotherString));
		System.out.println(aString.equals(aString));
		System.out.println(aString.equalsIgnoreCase(aString));
		
		String name = "Ted";
		int age = 32;
		double price = 3.99;
		boolean isFalse = false;
		char period = ';';
		String formattedString = String.format("%s, age %s, paid $%.2f for bread %c\t%b\n"
												, name, age, price, period, isFalse);
		System.out.println(formattedString);
		//busca el primer index en la variable
		System.out.println("The first index if r in " + aString + " is"
							+ aString.indexOf('r'));
		System.out.println("The first index of g in " + aString + " is"
							+ aString.indexOf('g'));
		//busca el ultimo index por la variable
		System.out.println("The last index if r in " + aString + " is"
				+ aString.lastIndexOf('r'));
		System.out.println("The last index of g in " + aString + " is"
				+ aString.lastIndexOf('g'));
		
		//reemplaza
		System.out.println("Replace all 'r' chars in " + aString + " with '@' chars");
		System.out.println(aString.replace('r', '@'));
		System.out.println(aString.replace('R', '@'));

		//Comienza por
		System.out.println("Does " + aString + " start with rev? "
				+ aString.startsWith("rev"));
		System.out.println("Does " + aString + " start with rev? "
				+ aString.toLowerCase().startsWith("rev"));
		
		//Substrae / elimina
		System.out.println("Remove the first char of a string using Substring: "
				+ aString.substring(1));
		System.out.println("Remove the last 2 chars of a String using Substring: "
				+ aString.substring(0, aString.length()-2));
		System.out.println("Get something from the middle:  "
				+ aString.substring(2, 6));
		
		
		
		
		//Convierte a minuscula
		System.out.println(aString + " to LowerCase; " + aString.toLowerCase());
		//Convierte a mayuscula
		System.out.println(aString + " to UpperCase; " + aString.toUpperCase());

		input.close();
	}	
}
