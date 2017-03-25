import java.util.*;

public class RandomNumberQuiz {
	
	static int ran;

	public static void main(String[] args) {
		
		generateRan();
		guessingGame();
		
	}
	
	public static void generateRan() {
		ran = (int)(Math.random() * 100) + 1;
	}
	
	public static void guessingGame() {
		Scanner in = new Scanner(System.in);
		
		int guess;
		int count = 0;
		System.out.println("Number Guessing Game");
		do {
			System.out.println("Enter your guess between 1 and 100:");
			guess = in.nextInt();
			
			if (guess > 100) System.out.println("Your guess was above 100.");
			else if (guess < 0) System.out.println("Your guess was below 1.");
			if (guess > ran) System.out.println("Too high.");
			else if (guess < ran) System.out.println("Too low.");
			
			count++;
		} while (guess != ran);
		System.out.println("Correct!\nYou Win!\nIt took " + count + " guesses.");
		
		in.close();
	}

}
