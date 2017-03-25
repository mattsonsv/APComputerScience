import java.util.*;

public class DaysInTheMonths {

	public static void main(String[] args) {
		
		daysInTheMonths();

	}
	
	public static void daysInTheMonths() {
		Scanner in = new Scanner(System.in);
		
		int daysInMonths[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		int monthInput, yearInput;
		
		System.out.println("Please enter the number of month to check.");
		monthInput = in.nextInt();
		System.out.println("Please enter the year to check in.");
		yearInput = in.nextInt();
		
		if (isYearALeapYear(yearInput))
			daysInMonths[1] = 29;
		
		System.out.println("There are " + daysInMonths[monthInput - 1] + " in the " + 
							monthInput + numberSuffix(monthInput) + " month.");
		
	}
	
	public static boolean isYearALeapYear(int yearToCheck) {
		
		boolean isYearALeapYear = false;
		
		if (yearToCheck % 4 != 0) {
			isYearALeapYear = false;
		}
		else if (yearToCheck % 100 != 0) {
			isYearALeapYear = true;
		}
		else if (yearToCheck % 400 != 0) {
			isYearALeapYear = false;
		}
		else {
			isYearALeapYear = true;
		}
		
		return isYearALeapYear;
	}

	public static String numberSuffix(int numberToAddSuffixTo) {
		
		String suffix = "";
		
		if (numberToAddSuffixTo == 1)
			suffix = "st";
		else if (numberToAddSuffixTo == 2)
			suffix = "nd";
		else if (numberToAddSuffixTo == 3)
			suffix = "rd";
		else
			suffix = "th";
			
		return suffix;
	}
	
}
