
public abstract class Card {
	public enum Suit {
		Spade, Club, Heart, Diamond;
	}
	private boolean available = true;
	protected int face;
	protected Suit suit;
	
	public Card(int value, Suit inSuit) {
		face = value;
		suit = inSuit;
	}
	
	public abstract int value();
	
	public Suit suit() {return suit;}
	
	public boolean isAvailable() {return available;}
	public void markAvailable(){available = true;}
	public void markUnavailable() {available = false;}
}
