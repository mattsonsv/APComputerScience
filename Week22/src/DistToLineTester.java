import java.util.Scanner;

public class DistToLineTester {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the value of A:");
		DistToLine.A = in.nextDouble();
		System.out.println("Enter the value of B:");
		DistToLine.B = in.nextDouble();
		System.out.println("Enter the value of C:");
		DistToLine.C = in.nextDouble();
		System.out.println("Enter the x coordinate of the point:");
		double x = in.nextDouble();
		System.out.println("Enter the y coordinate of the point:");
		double y = in.nextDouble();
		System.out.println(DistToLine.getDist(x, y));
		
	}

}
