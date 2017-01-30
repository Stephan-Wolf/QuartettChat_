package application.copy;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Spielerstapel {
	
	private LinkedList<Karte> stapel;
	
	public Spielerstapel() {
		stapel = new LinkedList<Karte> ();
	}
	
	public Karte entferneKarte(){
		return stapel.removeLast();
	}
	
	void fuegeKarteObenHinzu (Karte k) {
		// hinten anh�ngen ?? adlast??
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
	
	public void zeigeKarten() {
		for (int i = 0; i < stapel.size(); i++) {
			stapel.get(i).printKarte();
		}
	}
	
}
