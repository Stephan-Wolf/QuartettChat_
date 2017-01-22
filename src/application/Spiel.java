package application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

public class Spiel {
	
	private final int SIEGER_SPIELER_1 = 1;
	private final int SIEGER_SPIELER_2 = 2;
	private final int GLEICHSTAND = 0;
	
	// oder besser letzterRundersieger_Spieler1 ??
	boolean aktuellerRundensieger_Spieler1;
	private Spieler spieler1;
	private Spieler spieler2;
	private Kartenstapel kartenstapel;
	private int spieler1KartenanzahlInt;
	private int spieler2KartenanzahlInt;
	private boolean spielende = false;
	
	// Werte der aufgedeckten Karte vom Spieler1
	private StringProperty spieler1Ps =  new SimpleStringProperty();
	private StringProperty spieler1Kmh =  new SimpleStringProperty();
	private StringProperty spieler1Verbrauch =  new SimpleStringProperty();
	private StringProperty spieler1Ccm =  new SimpleStringProperty();	
	private StringProperty spieler1Beschleunigung =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> spieler1Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 1 als StringProperty
	private StringProperty spieler1Kartenanzahl = new SimpleStringProperty();
	

	// Werte der aufgedeckten Karte vom Spieler2
	private StringProperty spieler2Ps =  new SimpleStringProperty();
	private StringProperty spieler2Kmh =  new SimpleStringProperty();
	private StringProperty spieler2Verbrauch =  new SimpleStringProperty();
	private StringProperty spieler2Ccm =  new SimpleStringProperty();	
	private StringProperty spieler2Beschleunigung =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> spieler2Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 2 als StringProperty
	private StringProperty spieler2Kartenanzahl = new SimpleStringProperty();
	
	
	public Spiel () {
		kartenstapel = new Kartenstapel();
		Spieler spieler1 = new Spieler();
		Spieler spieler2 = new Spieler();
				
		spieler1Ps.bind(spieler1.getObereKartePs());
		spieler1Kmh.bind(spieler1.getObereKarteKmh()); 
		spieler1Verbrauch.bind(spieler1.getObereKarteVerbrauch());
		spieler1Ccm.bind(spieler1.getObereKarteCcm());
		spieler1Beschleunigung.bind(spieler1.getObereKarteBeschleunigung());
		spieler1Img.bind(spieler1.getObereKarteImg());
		
		spieler2Ps.bind(spieler2.getObereKartePs());
		spieler2Kmh.bind(spieler2.getObereKarteKmh()); 
		spieler2Verbrauch.bind(spieler2.getObereKarteVerbrauch());
		spieler2Ccm.bind(spieler2.getObereKarteCcm());
		spieler2Beschleunigung.bind(spieler2.getObereKarteBeschleunigung());
		spieler2Img.bind(spieler2.getObereKarteImg());
		
	}
	
	public void starten () {
		spielende = false;
		this.kartenMischen();
		this.kartenAusteilen();
	}
	
	// ???????????
	public void spielWiederholen () {
		
	}
	
	private void kartenMischen() {
		this.kartenstapel.mischen();
	}
	

	private void kartenAusteilen(){
		List<Karte> list = kartenstapel.getList();
		Spielerstapel spielerstapel [] = kartenstapel.gebeSpielerstapel();
		spielerstapel[0].zeigeKarten();

		
		this.spieler1.empfangeStapel(spielerstapel[0]);
		spieler1KartenanzahlInt = spielerstapel[0].liefereKartenanzahl();
		spieler1Kartenanzahl.setValue(String.valueOf(spieler1KartenanzahlInt)); 
		
		this.spieler2.empfangeStapel(spielerstapel [1]);
		spieler2KartenanzahlInt = spielerstapel [1].liefereKartenanzahl();
		spieler2Kartenanzahl.setValue(String.valueOf(spieler2KartenanzahlInt));
	}
	
	public int ermittleRundenergebnis(String attribut) {
		int rundenergebnis = vergleicheAttribut("attribut");
		this.spielerstapelAktualisieren(rundenergebnis);
		this.aktualisiereAktuellerRundensieger(rundenergebnis);
		return rundenergebnis;
	}
	
	// AUCHTUNG - NOCH REFACORING -> int ergebnis = liefereVergleichsergebnis(StringProperty1, StringProperty2)
	private int vergleicheAttribut(String attribut){
		if(attribut.equals("ps")) {
			
			int ergebnis = liefereVergleichsergebnis(spieler1Ps, spieler2Ps);
			
			return ergebnis;
			
		} else if(attribut.equals("kmh")) {
			
			int ergebnis = liefereVergleichsergebnis(spieler1Kmh, spieler2Kmh);
			return ergebnis;
			
		} else if(attribut.equals("verbrauch")) {
			
			int ergebnis = liefereVergleichsergebnis(spieler1Verbrauch, spieler2Verbrauch);
			
			return ergebnis;
			
		} else if(attribut.equals("ccm")) {
			
			int ergebnis = liefereVergleichsergebnis(spieler1Ccm, spieler2Ccm);
			return ergebnis;
			
		} else if(attribut.equals("beschleunigung")) {
			
			int ergebnis = liefereVergleichsergebnis(spieler1Beschleunigung, spieler2Beschleunigung);
			return ergebnis;
		}
		return 0;
	}
	

	
	private int liefereVergleichsergebnis(StringProperty attributwert1, StringProperty attributwert2) {
		float attributwert1Float = Float.parseFloat(attributwert1.getValue());
		float attributwert2Float = Float.parseFloat(attributwert2.getValue());
		
		if (attributwert1Float > attributwert2Float) {
			return SIEGER_SPIELER_1;
		} else if (attributwert2Float > attributwert1Float) {
			return SIEGER_SPIELER_2;
		}
		else { 
			return GLEICHSTAND;
		}
	}
	
	// Refactoring??
	private void spielerstapelAktualisieren(int e) {
		if (e == SIEGER_SPIELER_1) {
			
			// spieler2
			Karte k = this.spieler2.gebeKarteZurueck();
			spieler2KartenanzahlInt--;
			spieler2Kartenanzahl.setValue(String.valueOf(spieler2KartenanzahlInt));
			
			if (spieler2KartenanzahlInt == 0) {
				spielende = true;
			} else {
				spieler2.obereKarteAufdecken();
			}

			// spieler1
			this.spieler1.empfangeKarte(k);
			spieler1KartenanzahlInt++;
			spieler1Kartenanzahl.setValue(String.valueOf(spieler1KartenanzahlInt));
			this.spieler1.verschiebeObereKarteNachUnten();
			spieler1.obereKarteAufdecken();
			
		} else if (e == SIEGER_SPIELER_2){
			
			// spieler1
			Karte k = this.spieler1.gebeKarteZurueck();
			spieler1KartenanzahlInt--;
			spieler1Kartenanzahl.setValue(String.valueOf(spieler1KartenanzahlInt));
			if (spieler1KartenanzahlInt == 0) {
				spielende = true;
			} else {
				spieler1.obereKarteAufdecken();
			}
			
			// spieler2
			this.spieler2.empfangeKarte(k);
			spieler2KartenanzahlInt++;
			spieler2Kartenanzahl.setValue(String.valueOf(spieler2KartenanzahlInt));
			this.spieler2.verschiebeObereKarteNachUnten();
			spieler1.obereKarteAufdecken();
		
		} else {
			this.spieler1.verschiebeObereKarteNachUnten();
			spieler1.obereKarteAufdecken();
			this.spieler2.verschiebeObereKarteNachUnten();
			spieler2.obereKarteAufdecken();
		}
		
	}
	
	private void aktualisiereAktuellerRundensieger(int rundenergebnis)  {
		if (rundenergebnis == SIEGER_SPIELER_1) {
			aktuellerRundensieger_Spieler1 = true;
		}
		else if (rundenergebnis == SIEGER_SPIELER_2) {
			aktuellerRundensieger_Spieler1 = false;
		}
	}
	
	
	// Refactoring??? read only??
	public StringProperty getSpieler1PsProperty () {
		return this.spieler1Ps;
	}
	
	public StringProperty getSpieler1KmhProperty () {
		return this.spieler1Kmh;
	}
	
	public StringProperty getSpieler1VerbrauchProperty () {
		return this.spieler1Verbrauch;
	}
	
	public StringProperty getSpieler1CcmProperty () {
		return this.spieler1Ccm;
	}
	
	public StringProperty getSpieler1BeschleunigungProperty () {
		return this.spieler1Beschleunigung;
	}
	
	
	public ObjectProperty<javafx.scene.image.Image> getSpieler1Img () {
		return this.spieler1Img;
	}
	
	// Refactoring??? read only??
	public StringProperty getSpieler2PsProperty () {
		return this.spieler2Ps;
	}
	
	public StringProperty getSpieler2KmhProperty () {
		return this.spieler2Kmh;
	}
	
	public StringProperty getSpieler2VerbrauchProperty () {
		return this.spieler2Verbrauch;
	}
	
	public StringProperty getSpieler2CcmProperty () {
		return this.spieler2Ccm;
	}
	
	public StringProperty getSpieler2BeschleunigungProperty () {
		return this.spieler2Beschleunigung;
	}
	
	public ObjectProperty<javafx.scene.image.Image> getSpieler2Img () {
		return this.spieler2Img;
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