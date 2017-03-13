package app;

/**
* PlayerCardStack.java
*
* @author  Stephan Wolf
* @version 1.0
* @since   2017/03 
*/

import java.util.LinkedList;

public class PlayerCardStack {
	
	private LinkedList<Card> cards;
	
	public PlayerCardStack() {
		cards = new LinkedList<Card> ();
	}
	
	public Card removeCard(){
		return cards.removeLast();
	}
	
	public void addCardOnTop (Card card) {
		cards.addLast(card);
		
	}
	
	public void addCardAtTheBottom (Card card) {
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
