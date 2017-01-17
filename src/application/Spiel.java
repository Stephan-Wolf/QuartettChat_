package application;

public class Spiel {
	
	public boolean vergleicheAttribut(){
		return true;
	}
	
	public void kartenAusteilen(){
		
	}

}


/* 

public class Stapel {
    public static void main(String[] args) {
    	boolean StapelLi = true;

    AutoKarten Stapel = new AutoKarten(1);
    Stapel.printAll();
    java.util.Collections.shuffle(Stapel.Karten);
    System.out.println();
    System.out.println("After shuffle");
    Stapel.printAll();
    
    AutoKarten StapelL = new AutoKarten();
    AutoKarten StapelR = new AutoKarten();
    System.out.println();
    
    for(Karten aktKarte: Stapel.Karten){
    	if(StapelLi){
    		StapelL.addKarte(aktKarte);
    	}else{
    		StapelR.addKarte(aktKarte);
    	}
    	
    	 StapelLi = !StapelLi;
    	
    }
    
    System.out.println();
    System.out.println("Stapel Links");
    StapelL.printAll();
    
    System.out.println();
    System.out.println("Stapel Rechts");
    StapelR.printAll();
    
    
    }


}

Spielablauf:

Spieler 1,2;
Kartenstapel;
Kartenstapel mischen;
Kartenstapel teilen;
Spieler 1 Kartenstapel links
Spieler 2 Kartenstapel rechts

Spieler1 wählt Elementattribut erster Karte Stapel links;
	Attribut wird verglichen mit Attribut erster Karte Stapel rechts;
	
wenn Spieler 1 gewonnen dann wie vorher und Spieler 1 bekommt Karte von Spieler 2;

wenn Spieler 2 gewonnen dann; 

Spieler2 wählt Elementattribut neuer erster Karte Stapel rechts;
	Attribut wird verglichen mit Attribut erster neuer Karte Stapel links;
	
wenn Spieler 2 gewonnen dann wie vorher und Spieler 2 bekommt Karte von Spieler 1;

wenn Stapel links und rechts leer, Spieler mit den meistens karten hat gewonnen;



*/