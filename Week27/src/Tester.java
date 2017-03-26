import java.util.*;

public class Tester {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("What is the slope of your line?");
		double slope = in.nextDouble();
		
		System.out.println("What is the y-intercept of your line?");
		double yIntc = in.nextDouble();
		
		LinearFunction line = new LinearFunction(slope, yIntc);
		
		System.out.println("\nSlope: " + line.getSlope());
		System.out.println("Y intercept: " + line.getYIntercept());
		System.out.println("Root: " + line.getRoot());
		
		System.out.println("\nWhat is an x value for which you wish to solve for y?");
		double x = in.nextDouble();
		double yValue = line.getYValue(x);
		System.out.println("Y for x = " + x + " is " + yValue);
		
		System.out.println("\nWhat is a y value for which you wish to solve for x?");
		double y = in.nextDouble();
		double xValue = line.getXValue(y);
		System.out.println("X for y = " + y + " is " + xValue);
	}
	
}
