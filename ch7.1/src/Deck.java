import java.util.ArrayList;

public class Deck<T extends Card> {
	public ArrayList<T> deck;
	public int undealtIndex = 0;
	
	public void setDeckOfCards(ArrayList<T> cards){}
	
	public void shuffle() {}
	
	public int remainingCards() {
		return deck.size() - undealtIndex;
	}
	public int T dealCard() {}
	public int T[] dealHand(int number) {}
}
