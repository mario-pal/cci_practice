
public class BlackJackCard extends Card {
	public BlackJackCard(int face, Suit suit) {
		super(face, suit);
	}
	public int value() {
		if (isAce(face)) return 1;
		else if(face > 1 && face <= 10)
			return face;
		else{
			return face;
		}
	}
	
	public boolean isAce(int face) {
		return face == 1;
	}
	
	public int minValue() {
		if(isAce(face)) return 1;
		else return value();
	}
	
	public int maxValue() {
		if(isAce(face)) return 11;
		else return value();
	}
	
	public boolean isFaceCard() {
		return face >= 11 && face <= 13;
	}
}
