import java.util.*;

public class MailingLabel {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String name = "";
		String address = "";
		String city = "";
		String state = "";
		String zipCode = "";
		
		System.out.println("Please enter your name:");
		name = in.nextLine();
		System.out.println("Please enter your street address:");
		address = in.nextLine();
		System.out.println("Please enter your city of residence:");
		city = in.nextLine();
		System.out.println("Please enter you state of residence:");
		state = in.nextLine();
		System.out.println("Please enter your zip code:");
		zipCode = in.nextLine();
		
		System.out.println(name);
		System.out.println(address);
		System.out.println(city + ", " + state + " " + zipCode);

	}

}
