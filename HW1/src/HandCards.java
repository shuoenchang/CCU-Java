
public class HandCards {
	private static final String[] FACES = { "Deuce", "Three", "Four", "Five", "Six",
			"Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace" };
	private static final String[] SUITS = { "Diamonds", "Clubs", "Hearts", "Spades" };
	private Card[] inHand = new Card[52];
	private int[] countOfFace = new int[FACES.length];
	private int[] countOfSuit = new int[SUITS.length];
	private int currentInsert;	// index for current insert
	private int best;	// best hands
	private int value;	// best cards in hands
	
	// Constructor
	public HandCards() {
		currentInsert = 0;
		best = -1;
		value = -1;
	}
	
	/* insertCard into HandCards */
	public void insertCard(Card insert) {
		inHand[currentInsert] = insert;
		
		// count for face and suit
		for(int i=0; i<FACES.length; i++) 
			if(inHand[currentInsert].getFace() == FACES[i])
				countOfFace[i]++;
		for(int i=0; i<SUITS.length; i++)
			if(inHand[currentInsert].getSuit() == SUITS[i])
				countOfSuit[i]++;
		currentInsert++;
	}
	
	public int OnePair() {
		int ans = -1;
		for(int i=0; i<FACES.length; i++) 
			if(countOfFace[i] == 2)
				ans = i;	// the larger number
		return ans;
	}
	
	public int TwoPair() {
		int count = 0;
		int ans = -1;
		for(int i=0; i<FACES.length; i++)
			if(countOfFace[i] == 2) {
				count++;
				ans = i;	// the larger number
			}
		if(count<2)
			ans = -1;
		return ans;
	}
	
	/* ex : three aces */
	public int ThreeOfKind() {
		int ans = -1;
		for(int i=0; i<FACES.length; i++) 
			if(countOfFace[i] == 3)
				ans = i;
		return ans;
	}
	
	/* ex : four aces */
	public int FourOfKind() {
		int ans = -1;
		for(int i=0; i<FACES.length; i++) 
			if(countOfFace[i] == 4)
				ans = i;
		return ans;
	}
	
	/* all five cards of the same suit */
	public int Flush() {
		int ans = -1;
		for(int i=0; i<SUITS.length; i++)
			if(countOfSuit[i] == 5) 
				ans = 0;	
		// For flush, each face has only one, will check in Compare
		return ans;
	}
	
	/* five cards of consecutive face values */
	public int Straight() {
		int ans = -1;
		
		// check if consecutive 5 cards
		for(int i=0; i+4<FACES.length; i++) {
			for(int j=0; j<5; j++) {
				if(countOfFace[i+j] < 1)	// no card
					break;
				if(j == 4)	// consecutive 5 cards
					ans = i+j;
			}
		}
		
		// if there are Aces, need to check if exist 1 2 3 4 5
		if(countOfFace[FACES.length-1] > 0) {	// exist Aces
			for(int i=0; i<4; i++) {
				if(countOfFace[i] < 1)	// no card
					break;
				if(i == 3)	// exist 2 3 4 5
					ans = 3;
			}
		}
		
		return ans;
	}
	
	/* two cards of one face value and three cards of another face value */
	public int FullHouse() {
		int ans = -1;
		
		for(int i=0; i<FACES.length; i++) 
			if(countOfFace[i] == 3)	// exist three cards
				for(int j=0; j<FACES.length; j++)
					if(countOfFace[j] == 2)	// also exist two cards
						ans = i;
		
		return ans;
	}
	
	/* 
	 * FourOfKind > FullHouse > Flush > Straight > ThreeOfKind >
	 * TwoPair > OnePair
	 */
	public String Calculate() {
		int sol;
		sol = this.FourOfKind();
		
		if(sol > -1) {
			best = 6;
			value = sol;
			return "FourOfKind";
		}
		
		sol = this.FullHouse();
		if(sol > -1) {
			best = 5;
			value = sol;
			return "FullHouse";
		}
		
		sol = this.Flush();
		if(sol > -1) {
			best = 4;
			value = sol;
			return "Flush";
		}
		
		sol = this.Straight();
		if(sol > -1) {
			best = 3;
			value = sol;
			return "Straight";
		}
		
		sol = this.ThreeOfKind();
		if(sol > -1) {
			best = 2;
			value = sol;
			return "ThreeOfKind";
		}
		
		sol = this.TwoPair();
		if(sol > -1) {
			best = 1;
			value = sol;
			return "TwoPair";
		}
		
		sol = this.OnePair();
		if(sol > -1) {
			best = 0;
			value = sol;
			return "OnePair";
		}
		
		return "None";
	}
	
	// Compare two handcards, 1 means win, -1 means lose, 0 means draw
	public int CompareTo(HandCards opponent) {
		if(this.best > opponent.best)
			return 1;
		else if(this.best < opponent.best)
			return -1;
		else {
			if(this.value > opponent.value)
				return 1;
			else if(this.value < opponent.value)
				return -1;
		}
		
		/*
		 *  1. it is "None" 
		 *  2. value is the same, need to compare for others
		 *  3. Flush
		 */
		for(int i=12; i>=0; i--) {
			if(this.countOfFace[i] > opponent.countOfFace[i])
				return 1;
			if(this.countOfFace[i] < opponent.countOfFace[i])
				return -1;
		}
		return 0;
	}
	
	/* print Card in the object */
	public void Print() {
		for(int i=0; i<currentInsert; i++)
			System.out.println(inHand[i].toString());
	}
}
