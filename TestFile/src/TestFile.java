
public class TestFile {
	
	public static void main(String[] args) {
		
		System.out.println(girderAmount(33));
		System.out.println(factorial(9));
		System.out.println(bowlingPins(27));
		
	}
	
	private static int girderAmount(int meters) {
		return meters == 1 ? 3 : meters <= 0 ? 0 : 4 + girderAmount(--meters);
	}
	
	private static int factorial(int num) {
		return num == 1 || num == 0 ? 1 : num < 0 ? 0 : num * factorial(--num);
	}
	
	private static int bowlingPins(int rows) {
		return rows == 1 ? 1 : rows <= 0 ? 0 : rows + bowlingPins(--rows);
	}
	
	private static int stars(int stars) {
		
	}
	
}
