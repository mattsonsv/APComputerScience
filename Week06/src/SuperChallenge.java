import java.util.*;

public class SuperChallenge {
	
	static int input;
	static int inputReverse;
	
	public static void main(String[] args) {
		
		getInput();
		reverseInput();
		checkPalindrome();

	}
	
	public static void getInput() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a three digit integer:");
		input = in.nextInt();
	}
	
	public static void reverseInput() {
		String reverse = new StringBuffer(Integer.toString(input)).reverse().toString();
		inputReverse = Integer.parseInt(reverse);
	}
	
	public static void checkPalindrome() {
		if (input == inputReverse) {
			System.out.println(input + " is a palindrome.");
		} else {
			System.out.println(input + " is not a palindrome.");
		}
	}

}
