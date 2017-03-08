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
		// hinten anh�ngen ?? adlast??
		cards.addLast(card);
		
	}
	
	public LinkedList<Card> getAllCards() {
	       return cards;
	}
	
	void addCardAtTheBottom (Card card) {
		// vorne anh�ngen
		cards.addFirst(card);
	}
	
//	void setCards (LinkedList<Card> cards) {
//		this.cards = cards;
//	}
	
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
