import java.util.*;

public class CoinFlipper {
	
	public static int amount;
	public static int count = 0;
	public static ArrayList<Integer> flips = new ArrayList<Integer>();
	public static double heads, tails;
	public static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		getAmount();
		getInput();
		output();
		in.close();
		
	}
	
	public static void getAmount() {
		System.out.println("How many flips to analyze?");
		amount = in.nextInt();
	}
	
	public static void getInput() {
		System.out.println("Flip a coin and enter the result(1 for heads and 0 for tails)");
		int temp = in.nextInt();
		flips.add(count, temp);
		
		if (flips.size() != amount) {
			getInput();
		}
	}
	
	public static void output() {
		for (int i = 0; i < amount; i++) {
			if (flips.get(i) == 0)
				tails++;
			else
				heads++;
		}
		heads /= amount; // Proportion of flips
		tails /= amount; // Proportions of flips
		
		System.out.println(heads * amount + " heads: " + heads * 100 + "%");
		System.out.println(tails * amount + " tails: " + tails * 100 + "%");
	}
	
}
