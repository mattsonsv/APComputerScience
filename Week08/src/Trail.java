
public class Trail {
	
	public static int x, y;
	public static String s;
	
	public Trail(String input) {
		s = input;
		x = 10;
		y = 10;
	}
	
	public static String met() { 
		return Integer.toHexString(x * y);
	}

}
