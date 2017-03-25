
public class DeckOfCards {
	
	private int[] deck = new int[52];
	private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
	private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
	
	public DeckOfCards() {
		// Default as pyramid
		for (int i = 0; i < deck.length; i++) {
			if (i < deck.length / 2)
				deck[i] = i;
			else
				deck[i] = deck.length - 1 - (i - deck.length / 2);
		}
	}
	
	public DeckOfCards(int pattern) {
		// 1: Descending
		switch (pattern) {
			case 1:
				for (int i = 0; i < deck.length; i++)
					deck[i] = deck.length - 1 - i;
				break;
		//2: Ascending
			case 2:
				for (int i = 0; i < deck.length; i++)
					deck[i] = i;
				break;
				
		//Default: Pyramid
			default:
				for (int i = 0; i < deck.length; i++)
					if (i < deck.length / 2)
						deck[i] = i;
					else
						deck[i] = deck.length - 1 - (i - (deck.length / 2));
				break;
		}
	}
	
	public void shuffle() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < deck.length; j++) {
				int a = (int)(Math.random() * deck.length);
				int b = (int)(Math.random() * deck.length);
				
				int swap = deck[a];
				deck[a] = deck[b];
				deck[b] = swap;
			}
		}
	}
	
	public void printDeck() {
		for (int i = 0; i < deck.length; i++) {
			System.out.println(deck[i] + ":\t" + ranks[deck[i] % 13] + "\tof\t" + suits[deck[i] / 13]);
		}
	}
	
}
