
import java.security.SecureRandom;

public class DeckOfCards {
	private Card[] deck;
	private int currentCard;	// index for deal card
	private static final int NUMBER_OF_CARDS = 52;
	private static final String[] FACES = { "Deuce", "Three", "Four", "Five", "Six",
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };
	
	
	private static final String[] SUITS = { "Diamonds", "Clubs", "Hearts", "Spades" };	
	private static final SecureRandom randomNumbers = new SecureRandom();
	
	// Constructor
	public DeckOfCards() {
		
		deck = new Card[NUMBER_OF_CARDS];
		currentCard = 0;
		
		for(int count = 0; count<deck.length; count++)
			this.deck[count]= new Card(FACES[count % FACES.length], 
										SUITS[count / FACES.length]);
	}
	
	// shuffle deck of Cards with Fisher–Yates algorithm
	public void shuffle() {
		currentCard = 0;
		
		/* To shuffle an array a of n elements (indices 0..n-1):
		 * for i from n − 1 downto 1 do
		 * 		j ← random integer such that 0 ≤ j ≤ i
		 * 		exchange a[j] and a[i]
		 */
		for(int i = NUMBER_OF_CARDS-1; i>0; i--) {
			/* select a random number between 0 and i (both inclusive) */
			int j = randomNumbers.nextInt(i+1);
			
			// Swap
			Card temp = deck[i];
			deck[i] = deck[j];
			deck[j] = temp;
		}
	}
	
	// deal one Card
	public Card dealCard() {
		if(currentCard < deck.length)
			return deck[currentCard++];
		else
			return null;
	}
}
