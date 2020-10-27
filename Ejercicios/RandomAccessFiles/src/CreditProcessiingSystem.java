import java.io.*;
import java.util.*;

public class CreditProcessiingSystem {
	public static String dataFilePath = "C:\\Users\\dcastilh\\Documents\\GitHub\\Java\\Ejercicios\\RandomAccessFiles\\src\\CreditProcessingData";
	public static final int RECORD_LENGTH = 16;
	public static void main(String[] args) {
		RandomAccessFile cData = null;
		try {
			cData = new RandomAccessFile(dataFilePath, "rw");
			boolean done = false;
			Scanner input = new Scanner(System.in);
			while (!done) {
				int choice = printMenu();
				long ccNum;
				int position;
				
				switch (choice) {
				case 1:
					CreditCard cc = getNewCardDetails();
					cData.seek(cData.length());
					cData.writeLong(cc.getCreditCardNumber());
					cData.writeDouble(cc.getBalance());
					System.out.println(cc.toString() + " added to the system.");
					break;
				case 2:
					System.out.println("Please enter the 16-digit number of the card to view");
					ccNum = Long.parseLong(input.nextLine());
					position = findCardPosition(ccNum, cData);
					if (position >= 0) {
						System.out.println("");
						displayCardDetails(position, cData);
						System.out.println();
					} else {
						System.out.println("No card with that number found.");
					}
					break;
				case 3:
					System.out.println("Please enter the 16-digit number of the card to view:");
					ccNum = Long.parseLong(input.nextLine());
					position = findCardPosition(ccNum, cData);
					
					if (position >= 0) {
						double newBalance = getBalance();
						if (newBalance >= 0.0) {
							cData.seek(position * RECORD_LENGTH);
							cData.writeLong(ccNum);
							cData.writeDouble(newBalance);
							System.out.println("Updated: " + ccNum + "to balance $" + newBalance);
						}
					} else {
						System.out.println("No card with that number found");
					}
					break;
				case 4:
					System.out.println("");
					long totalRecords = cData.length() / RECORD_LENGTH;
					if (totalRecords == 0) {
						System.out.println("No current cards on file");
					} else {
						for (int i = 0; i < totalRecords; i++) {
							displayCardDetails(i, cData);
						}
					}
					System.out.println("");
					break;
				case 5:
					default:
					done = true;
					break;
				}
			}
			System.out.println("Thank you for usin the credit card manager");
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (cData != null) {
				try {
					cData.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static int printMenu() {
		Scanner menuInput = new Scanner(System.in);
		System.out.println("Pleasae select from the following choices:");
		System.out.println("Enter 1 for adding a new credit card");
		System.out.println("Enter 2 for viewing details of a credit card");
		System.out.println("Enter 3 to update card details");
		System.out.println("Enter 4 to list all cards and balances");
		System.out.println("Enter 5 to quit");
		return Integer.parseInt(menuInput.nextLine());
	}
	
	private static CreditCard getNewCardDetails() {
		CreditCard cc = new CreditCard();
		cc.setCreditCardNumber(getCardNumber());
		cc.setBalance(getBalance());
		return cc;
	}
	
	private static long getCardNumber() {
		Scanner getNumber = new Scanner(System.in);
		String matchPattern = "[0-9]{16}";
		boolean valid = false;
		
		while(!valid) {
			System.out.println("Please enter a valid 16-digit credit card number:");
			String userNum = getNumber.nextLine();
			valid = userNum.matches(matchPattern);
			if (valid) {
				return Long.parseLong(userNum);
			}
		}
		return -1;
	}
	
	private static double getBalance() {
		Scanner getBalance = new Scanner(System.in);
		System.out.println("Please enter the current card balance:");
		return Double.parseDouble(getBalance.nextLine());
	}
	
	private static int findCardPosition(long cardNumber, RandomAccessFile f) throws IOException {
		
		long totalRecords = f.length() / RECORD_LENGTH;
		
		for (int i = 0; i < totalRecords; i++) {
			f.seek(i * RECORD_LENGTH);
			long ccNum = f.readLong();
			if (ccNum == cardNumber) {
				return 1;
			}
		}
		return -1;
	}
	
	private static void displayCardDetails(int position, RandomAccessFile f) throws IOException {
		f.seek(position * RECORD_LENGTH);
		CreditCard cc = new CreditCard(f.readLong(), f.readDouble());
		System.out.println("Card Details: " + cc.toString());
	}
}