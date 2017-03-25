import java.util.*;

public class NameReversal {
	
	static String name;

	public static void main(String[] args) {
		
		getUserName();
		System.out.println(reverseString(name));

	}
	
	public static void getUserName() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is your name?");
		name = in.nextLine();
		in.close();
	}
	
	public static String reverseString(String input) {
		String temp = "";
		String reverse = "";
		
		for (int i = 0; i < input.length(); i++) {
			temp = input.substring((input.length() - (i + 1)), (input.length() - reverse.length()));
			reverse += temp;
		}
		
		return reverse.toLowerCase();
	}

}
