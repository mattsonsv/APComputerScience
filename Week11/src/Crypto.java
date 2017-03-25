import java.util.*;

public class Crypto {
	
	public String encrypt(String toEncrypt) {
		String s = toEncrypt.trim();
		
		/*
		s = s.toLowerCase();
		for(int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'V': s = s.substring(0, i) + "ag\',r" + s.substring(i + 1, s.length()); i += 5;
				case 'v': s = s.substring(0, i) + "ag\',r" + s.substring(i + 1, s.length()); i += 5; break;
			case 'M': s = s.substring(0, i) + "ssad" + s.substring(i + 1, s.length()); i += 4;
				case 'm': s = s.substring(0, i) + "ssad" + s.substring(i + 1, s.length()); i += 4; break;
			case 'G': s = s.substring(0, i) + "jeb..w" + s.substring(i + 1, s.length()); i += 6;
				case 'g': s = s.substring(0, i) + "jeb..w" + s.substring(i + 1, s.length()); i += 6; break;
			case 'B': s = s.substring(0, i) + "dug>?/" + s.substring(i + 1, s.length()); i += 6;
				case 'b': s = s.substring(0, i) + "dug>?/" + s.substring(i + 1, s.length()); i += 6; break;
			default: break;
			}
		}*/
		
		s = s.replaceAll("[Vv]", "ag\',r");
		s = s.replaceAll("[Mm]", "ssad");
		s = s.replaceAll("(?!a)[Gg](?!',r)", "jeb..w");
		s = s.replaceAll("(?!je)[Bb](?!\\.\\.w)", "dug>?/");
		/* OR
		s = s.replaceAll("[Bb]", "dug>?/");
		s = s.replaceAll("(?!(a)|(du))[Gg](?!(',r)|(>\\?/))", "jeb..w");
		*/
		
		return s;
	}
	
	public String decrypt(String toDecrypt) {
		String s = toDecrypt.trim();
		
		s = s.replaceAll("(ag\',r)", "v");
		s = s.replaceAll("(ssad)", "m");
		s = s.replaceAll("(jeb\\.\\.w)", "g");
		s = s.replaceAll("(dug>\\?/)", "b");
		
		return s;
	}
	
}
