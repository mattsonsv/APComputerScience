
public class BankAccount {
	
	public double balance;
	public String name;
	
	public BankAccount(double bal, String nam) {
		balance = bal;
		name = nam;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withdraw(double amount) {
		balance -= amount;
	}
	
}
