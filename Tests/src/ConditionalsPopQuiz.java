import java.util.*;

public class ConditionalsPopQuiz {
	
	static int age;
	static int yearsAtJob;
	static int benefitLevel;
	static boolean canRetire;

	public static void main(String[] args) {
		
		getUserInput();
		benefitLevel();
		output();
		
	}
	
	public static void getUserInput() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("How old are you?");
		age = in.nextInt();
		System.out.println("How many years have you worked at your job?");
		yearsAtJob = in.nextInt();
	}
	
	public static void benefitLevel() {
		if (age >= 62 && yearsAtJob >= 25) {
			benefitLevel = 100;
			canRetire = true;
		} else if (age >= 58 && yearsAtJob >= 20) {
			benefitLevel = 80;
			canRetire = true;
		} else if (age >= 55 && (yearsAtJob >= 15 && yearsAtJob < 20)) {
			benefitLevel = 50;
			canRetire = true;
		} else if (age < 55 || yearsAtJob <  15) {
			benefitLevel = 0;
			canRetire = false;
		} else {
			canRetire = false;
		}
	}
	
	public static void output() {
		if(!canRetire) {
			System.out.println("You can retire, but with no benefits");
		} else {
			System.out.println("You can retire.");
			System.out.println("You will have a " + benefitLevel + "% benefit rate if you retire.");
		}
	}

}
