import java.util.*;
import java.text.*;

public class BankTester {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		NumberFormat money = NumberFormat.getNumberInstance();
		money.setMinimumFractionDigits(2);
		money.setMaximumFractionDigits(2);
		
		ArrayList<BankAccount> accounts = new ArrayList<>();
		
		String input = "";
		while(!input.equalsIgnoreCase("exit")) {
			System.out.println("Please enter the name to whom the account belongs. (\"Exit\" to abort)");
			String name = in.nextLine();
			if (name.equalsIgnoreCase("exit")) break;
			System.out.println("Please enter the amount of the deposit.");
			double amount = in2.nextDouble();
			
			accounts.add(new BankAccount(name, amount));
		}
		
		BankAccount control = accounts.get(0);
		for (int i = 1; i < accounts.size(); i++) {
			BankAccount compare = accounts.get(i);
			if (compare.getBalance() > control.getBalance())
				control = accounts.get(i);
		}
		
		System.out.println("The account with the largest balance belongs to " + control.getName());
		System.out.println("The amount is $" + control.getBalance());
		
	}
	
}
