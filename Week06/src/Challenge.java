import java.util.*;

public class Challenge {
	
	static ArrayList<Integer> input = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		getInput();
		output();

	}
	
	public static void getInput() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a three digit integer:");
		int temp = in.nextInt();
		
		int i = 0;
		while (temp > 0) {
			input.add(i, temp % 10);
			temp /= 10;
			i++;
		}
	}
	
	public static void output() {
		Collections.sort(input);
		
		for (int i = 0; i < input.size(); i++) {
			System.out.println(input.get(i));
		}
	}

}
