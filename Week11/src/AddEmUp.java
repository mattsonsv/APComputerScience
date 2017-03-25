import java.util.*;

public class AddEmUp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter something like 8 + 33 + 1345 - 137 : ");
		String s = in.nextLine();
		
		Scanner sc = new Scanner(s);
		sc.useDelimiter("\\s*");
		
		int sum = 0;
		String temp = "";
		
		while(sc.hasNext()) {
			temp = sc.next();
			if (temp.equals("+"))
				sum += sc.nextInt();
			else if (temp.equals("-"))
				sum -= sc.nextInt();
			else
				sum += Integer.parseInt(temp);
		}
		
		System.out.println("Sum is: " + sum);
		
		in.close();
		sc.close();
		
	}

}
