package application;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Spielerstapel {
	
	private LinkedList<Karte> stapel;
	
	public Spielerstapel() {
	}
	
	public Karte entferneKarte(){
		return stapel.removeLast();
	}
	
	void fuegeKarteObenHinzu (Karte k) {
		// hinten anh�ngen
		stapel.addLast(k);
	}
	
	public LinkedList<Karte> getList() {
	       return stapel;
	}
	
	void fuegeKarteUntenHinzu (Karte k) {
		// vorne anh�ngen
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
