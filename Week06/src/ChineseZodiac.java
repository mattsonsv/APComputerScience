import java.util.*;

public class ChineseZodiac {

	public static void main(String[] args) {
		
		userZodiac();

	}
	
	public static void userZodiac() {
		Scanner in = new Scanner(System.in);
		
		int input;
		
		System.out.println("Please enter a year.");
		input = in.nextInt();
		
		System.out.println("The Chinese Zodiac sign for the year " + input + " is the " + zodiacYear(input));
		
	}
	
	public static String zodiacYear(int yearToCheck) {
		
		String zodiac = "";
		
		switch ((yearToCheck - 4) % 12) {
		case 0: zodiac = "Rat";	break;
		case 1: zodiac = "Ox";	break;
		case 2: zodiac = "Tiger";	break;
		case 3: zodiac = "Rabbit";	break;
		case 4: zodiac = "Dragon";	break;
		case 5: zodiac = "Snake";	break;
		case 6: zodiac = "Horse";	break;
		case 7: zodiac = "Goat";	break;
		case 8: zodiac = "Monkey";	break;
		case 9: zodiac = "Rooster";	break;
		case 10: zodiac = "Dog";	break;
		case 11: zodiac = "Pig";	break;
		}
		
		return zodiac;
	}

}
