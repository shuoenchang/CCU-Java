
public class Game {
	
	public static void main(String[] args) {
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle();
		
		HandCards first = new HandCards();
		HandCards second = new HandCards();
		HandCards third = new HandCards();
		HandCards forth = new HandCards();	
		
		for(int i=0; i<5; i++) {
			first.insertCard(myDeckOfCards.dealCard());
			second.insertCard(myDeckOfCards.dealCard());
//			third.insertCard(myDeckOfCards.dealCard());
//			forth.insertCard(myDeckOfCards.dealCard());
		}
		
		System.out.printf("First------%s\n", first.Calculate());
		first.Print();
		
		System.out.printf("\nSecond------%s\n", second.Calculate());
		second.Print();
		
		System.out.printf("\nThird------%s\n", third.Calculate());
		third.Print();
		System.out.printf("\nForth------%s\n", forth.Calculate());
		forth.Print();
		
		System.out.print("\n\nThe winner is: ");
		int sol = first.CompareTo(second);
		if(sol > 0)
			System.out.print("First");
		else if(sol < 0)
			System.out.print("Second");
		else
			System.out.print("Draw");
	}
}
