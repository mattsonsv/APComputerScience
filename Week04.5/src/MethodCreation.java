import java.util.*;

public class MethodCreation {
	
	//Variables
	static int input1, input2;
	
	public static void main(String[] args) {
		
		getInfo();
		
		intSum();
		
		intDifference();
		
		intProduct();
		
		intQuotient();
		
		intAverage();
		
	}
	
	public static void getInfo() {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Please enter an integer.");
		input1 = in.nextInt();
		System.out.println("Please enter another integer.");
		input2 = in.nextInt();
		
	}
	
	public static void intSum() {
		
		int sum = 0;
		
		sum = (input1 + input2);
		
		System.out.println("The sum of " + input1 + " and " + input2 + " is " + sum);
		
	}
	
	public static void intDifference() {
		
		int difference = 0;
		
		difference = (input1 - input2);
		
		System.out.println("The difference of " + input1 + " and " + input2 + " is " + difference);
		
	}
	
	public static void intProduct () {
		
		int product = 0;
		
		product = (input1 * input2);
		
		System.out.println("The product of " + input1 + " and " + input2 + " is " + product);
		
	}
	
	public static void intQuotient() {
		
		double quotient = 0.0;
		
		quotient = ((double)input1 / input2);
		
		System.out.println("The quotient of " + input1 + " and " + input2 + " is " + quotient);
		
	}
	
	public static void intAverage() {
		
		double average = 0.0;
		
		average = ((double)input1 + input2) / 2;
		
		System.out.println("The average of " + input1 + " and " + input2 + " is " + average);
		
	}

}
