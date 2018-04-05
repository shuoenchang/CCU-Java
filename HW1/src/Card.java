
public class Card {
	private final String face;	// Ace, 2, 3...
	private final String suit;	// Hearts, Diamonds...
	
	// Constructor
	public Card(String cardFace, String cardSuit) {
		this.face = cardFace;
		this.suit = cardSuit;
	}
	
	// return String representation
	@Override
	public String toString() {
		return face + " of " + suit;
	}
	
	public String getFace() {
		return face;
	}
	
	public String getSuit() {
		return suit;
	}
}
