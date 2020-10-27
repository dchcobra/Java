import java.io.Serializable;

public class CreditCard implements Serializable {
	private long ccNunm;
	private double balance;
	
	public CreditCard() {
		//do nothing
	}
	
	public CreditCard(long ccNunml, double balancel) {
		ccNunm = ccNunml;
		balance = balancel;
	}
	
	public long getCreditCardNumber() {
		return ccNunm;
	}
	
	public void setCreditCardNumber(long num) {
		ccNunm = num;
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
