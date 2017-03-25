import java.util.*;

public class ItsMyBirthday {

	public static void main(String[] args) {

		//Scanner
		Scanner in = new Scanner(System.in);
		
		//Question Variables
		String firstName = "";
		String lastName = "";
		int dayOfBirth, monthOfBirth;
		dayOfBirth = 0;
		monthOfBirth = 0;
		int currentDay, currentMonth, currentYear;
		currentDay = 0;
		currentMonth = 0;
		currentYear = 0;
		
		//User Input Questions
		System.out.println("What is your first name?");
		firstName = in.nextLine();
		
		System.out.println("What is your last name?");
		lastName = in.nextLine();
		
		System.out.println("What the number month were you born?");
		monthOfBirth = in.nextInt();
		
		System.out.println("What day of the month were you born?");
		dayOfBirth = in.nextInt();
		
		System.out.println("What number month is it currently?");
		currentMonth = in.nextInt();
		
		System.out.println("What day of the month is it currently?");
		currentDay = in.nextInt();
		
		System.out.println("What year is it currently?");
		currentYear = in.nextInt();
		
		//Various Variables Relating to Leap Years, Days in a Year, and Days in Any Month
		int daysInYear = 0;
		int daysInNextYear = 0;
		int daysInMonths[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		boolean isThisYearALeapYear = false;
		boolean isNextYearALeapYear = false;
		
		//Leap Year Checks
		if (currentYear % 4 != 0) {
			isThisYearALeapYear = false;
		}
		else if (currentYear % 100 != 0) {
			isThisYearALeapYear = true;
		}
		else if (currentYear % 400 != 0) {
			isThisYearALeapYear = false;
		}
		else {
			isThisYearALeapYear = true;
		}
		
		//Next Year Leap Year Checks
		if (currentYear++ % 4 != 0) {
			isNextYearALeapYear = false;
		}
		else if (currentYear++ % 100 != 0) {
			isNextYearALeapYear = true;
		}
		else if (currentYear++ % 400 != 0) {
			isNextYearALeapYear = false;
		}
		else {
			isNextYearALeapYear = true;
		}
		
		//Leap Year Fixes
		if (isThisYearALeapYear) {
			daysInMonths[1] = 29;
		}
		if (!isNextYearALeapYear) {
			daysInNextYear--;
		}
		
		//Days in Year
		for (int i = 0; i < daysInMonths.length; i++){
			daysInYear += daysInMonths[i];
		}
		daysInNextYear = daysInYear;
		
		//Current Day of Year
		int currentDayOfYear = 0;
		
		for (int i = 0; i < currentMonth; i++){
			currentDayOfYear += daysInMonths[i];
		}
		currentDayOfYear += currentDay;
		
		//Birthday Day of Year
		int birthdayDayOfYear = 0;
		
		for (int i = 0; i < monthOfBirth; i++){
			birthdayDayOfYear += daysInMonths[i];
		}
		birthdayDayOfYear += dayOfBirth;
		
		//Is Birthday This Year Checks
		boolean isBirthdayLaterThisYear = false;
		
		if (birthdayDayOfYear > currentDayOfYear) {
			isBirthdayLaterThisYear = true;
		}
		
		//Leap Year Checks in Relation To Next Year Birthdays
		int leapDay = 60;
		
		if (daysInYear > daysInNextYear && birthdayDayOfYear > leapDay && !isBirthdayLaterThisYear) {
			birthdayDayOfYear--;
		}
		else if(daysInYear < daysInNextYear && birthdayDayOfYear > leapDay && !isBirthdayLaterThisYear) {
			birthdayDayOfYear++;
		}

		//Days Until Birthday
		int daysUntilBirthday = 0;
		
		if (isBirthdayLaterThisYear) {
			daysUntilBirthday = birthdayDayOfYear - currentDayOfYear;
		}
		else {
			daysUntilBirthday = birthdayDayOfYear + (daysInYear - currentDayOfYear);
		}
		
		//Output
		System.out.println("Hi " + firstName);
		System.out.println("It will be " + firstName + " " + lastName + "'s birthday in " + daysUntilBirthday + " days.");
		
	}

}
