import java.util.*;
public class BasicRegexRules {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String regexPhoneNumber = "\\d{3}-\\d{3}-\\d{4}";
		System.out.println("Please enter a phone number as XXX-XXX-XXXX: ");
		String inPhone = input.nextLine();
		if (inPhone.matches(regexPhoneNumber)) {
			System.out.println("Thank u for entering a valid phone number!");
		} else {
			System.out.println("This number: " + inPhone + " is not active phone number is format XXX-XXX-XXXX");
		}
		
		String validCharactersRegex = "[0-9A-Za-z]";
		System.out.println("Please enter a new password, using only letters and numbers: ");
		String inPassword = input.nextLine();
		if (inPassword.matches(validCharactersRegex)) {
			System.out.println("Your new password has been recorded!");
		} else {
			System.out.println("We're sorry, this password is invalid!");
		}
		
		
		String validCharactersRegex2 = "[0-9A-Za-z]{8}";
		System.out.println("Please enter a new password, using exactly any 8 letters and numbers: ");
		inPassword = input.nextLine();
		if (inPassword.matches(validCharactersRegex2)) {
			System.out.println("Your new password has been recorded!");
		} else {
			System.out.println("We're sorry, this password is invalid!");
		}
		
		String validCharactersRegex3 = "[0-9A-Za-z]{7}[^0-9A-Za-z]{1}";
		System.out.println("Please enter a new password, using exactly any 7 letters and numbers"
				+ " and exactly one special character in it at the end");
		inPassword = input.nextLine();
		if (inPassword.matches(validCharactersRegex3)) {
			System.out.println("Your new password has been recorded!");
		} else {
			System.out.println("We're sorry, this password is invalid!");
		}
		
		String nameStrSWB = "^B[\\w]*";
		String nameStrEWn = "[\\w]*n$";
		String nameStrA = ".*a.*";
		ArrayList<String> names = new ArrayList<String>();
		names.add("Adam");
		names.add("Jason");
		names.add("Brian");
		names.add("Suzanne");
		names.add("Melissa");
		names.add("Angie");
		names.add("Belinda");
		names.add("Becky");

		for (String n : names) {
			if (n.matches(nameStrSWB)) {
				System.out.println("Starts with B: " + n);
			}
			if (n.matches(nameStrEWn)) {
				System.out.println("Ends with B: " + n);
			}
			if (n.matches(nameStrA)) {
				System.out.println("Contains an a: " + n);
			}
		}
	}
}
