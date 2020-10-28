import java.io.Serializable;

public class CreditCard implements Serializable {
	private long ccNum;
	private double balance;
	
	public CreditCard() {
		//do nothing
	}
	
	public CreditCard(long ccNuml, double balancel) {
		ccNum = ccNuml;
		balance = balancel;
	}
	
	public long getCreditCardNumber() {
		return ccNum;
	}
	
	public void setCreditCardNumber(long num) {
		ccNum = num;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double bal) {
		balance = bal;
	}
	public String toString() {
		return String.format("Credit Card Number: %d\tBalance $%.2f"
				, getCreditCardNumber()
				, getBalance());
	}
}
