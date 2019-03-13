import java.util.ArrayList;

public class Hand<T extends Card> {
	protected ArrayList<T> cards = new ArrayList<T>();
	
	public int score() {
		int totalScore = 0;
		
		for (T c : cards) {
			totalScore += c.value();
		}
		return totalScore;
	}
	
	public void addCard(T givenCard) {
		cards.add(givenCard);
	}
	
}
