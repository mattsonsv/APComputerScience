import java.util.*;

public class CryptoTester {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Crypto crypt = new Crypto();
		
		System.out.println("Enter a sentence that is to be encrypted:");
		String sentence = in.nextLine();
		//The quick fox jumps over the lazy brown dog
		//This is a very big morning
		System.out.println("\nOriginal Sentence: " + sentence);
		
		String encryptedSentence = crypt.encrypt(sentence);
		System.out.println("Encrypted Sentence: " + encryptedSentence);
		
		String decryptedSentence = crypt.decrypt(encryptedSentence);
		System.out.println("Decrypted Sentence: " + decryptedSentence);
		
	}

}
