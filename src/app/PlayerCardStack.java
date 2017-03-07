package app;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class PlayerCardStack {
	
	private LinkedList<Card> stapel;
	
	public PlayerCardStack() {
		stapel = new LinkedList<Card> ();
	}
	
	public Card entferneKarte(){
		return stapel.removeLast();
	}
	
	void fuegeKarteObenHinzu (Card k) {
		// hinten anh�ngen ?? adlast??
		stapel.addLast(k);
		
	}
	
	public LinkedList<Card> getList() {
	       return stapel;
	}
	
	void fuegeKarteUntenHinzu (Card k) {
		// vorne anh�ngen
		stapel.addFirst(k);
	}
	
	void setStapel (LinkedList<Card> k) {
		stapel = k;
	}
	
	public Card gebeObereKarte() {
		return stapel.getLast();
	}
	
	public int liefereKartenanzahl () {
		int kartenanzahl = stapel.size();
		return kartenanzahl;
	}
	
	public void zeigeKarten() {
		for (int i = 0; i < stapel.size(); i++) {
			stapel.get(i).printKarte();
		}
	}
	
}
