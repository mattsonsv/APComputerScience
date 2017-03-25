
public class TableOfBases {

	public static void main(String[] args) {
		
		System.out.println("Decimal\t\tBinary\t\tOctal\t\tHex\t\tCharacter");
		for (int i = 65; i < 91; i++) {
			System.out.println(i + "\t\t" + Integer.toBinaryString(i) + "\t\t" + Integer.toOctalString(i) + "\t\t" + 
					Integer.toHexString(i) + "\t\t" + (char)i);
		}

	}

}
