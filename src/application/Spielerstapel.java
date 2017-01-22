package application;

import java.util.LinkedList;
import java.util.Collections;

public class Spielerstapel {
	
	private LinkedList<Karte> stapel;
	
	public Spielerstapel() {
	}
	
	public Karte entferneKarte(){
		return stapel.removeLast();
	}
	
	void fuegeKarteObenHinzu (Karte k) {
		// hinten anhängen
		stapel.addLast(k);
	}
	
	void fuegeKarteUntenHinzu (Karte k) {
		// vorne anhängen
		stapel.addFirst(k);
	}
	
	void setStapel (LinkedList<Karte> k) {
		stapel = k;
	}
	
	public Karte gebeObereKarte() {
		return stapel.getLast();
	}
	
	public int liefereKartenanzahl () {
		int kartenanzahl = stapel.size();
		return kartenanzahl;
	}
	

}
