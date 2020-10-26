import java.util.*;

public class ShowCustomCheckedException {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter any number");
		
		try {
			int anyNumber = Integer.parseInt(input.nextLine());
			if (anyNumber < 100) {
				throw new CustomCheckedException("Number is too small plaese don't do this!");
			}
		} catch (NumberFormatException nfe) {
			System.out.println("Please enter a number next time");
		} catch (CustomCheckedException cce) {
			System.out.println(cce.getMessage());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		} 
		
	}
}
