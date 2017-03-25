import java.util.*;

public class WhatsMyGrade {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		double grade = 0.0;
		double score1, score2, score3;
		score1 = 0.0;
		score2 = 0.0;
		score3 = 0.0;
		
		System.out.println("Please enter your first test score:");
		score1 = in.nextDouble();
		System.out.println("Please enter your second test score:");
		score2 = in.nextDouble();
		System.out.println("Please enter your third test score:");
		score3 = in.nextDouble();
		
		grade = (score1 + score2 + score3) / 3.0;
		
		System.out.println("Your grade is " + grade);

	}

}
