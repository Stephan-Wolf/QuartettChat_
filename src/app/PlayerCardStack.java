package app;

import java.util.LinkedList;

public class PlayerCardStack {
	
	private LinkedList<Card> cards;
	
	public PlayerCardStack() {
		cards = new LinkedList<Card> ();
	}
	
	public Card removeCard(){
		return cards.removeLast();
	}
	
	void addCardOnTop (Card card) {
		cards.addLast(card);
		
	}
	
	void addCardAtTheBottom (Card card) {
		cards.addFirst(card);
	}
		
	public Card getTopCard() {
		return cards.getLast();
	}
	
	public int getNumberOfCards () {
		int numberOfCards = cards.size();
		return numberOfCards;
	}
	
	public void printCards() {
		for (int i = 0; i < cards.size(); i++) {
			cards.get(i).printCard();
		}
	}
	
}
