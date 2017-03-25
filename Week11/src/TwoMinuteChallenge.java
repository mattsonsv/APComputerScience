import java.util.*;

public class TwoMinuteChallenge {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int input;
		
		do {
			System.out.println("Enter a number between 1 and 30");
			input = in.nextInt();
		} while (input > 30 || input < 1);
		
		System.out.println(input);
		int length = 10 + input;
		for (int i = input; i < length; i++) {
			if (i % 3 == 0)
				System.out.println(i);
			else
				length++;
		}
		
	}

}
