package app;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.BooleanProperty;

import java.util.List;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Spiel extends UnicastRemoteObject implements IModel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int SIEGER_SPIELER_1 = 1;
	private final int SIEGER_SPIELER_2 = 2;
	private final int GLEICHSTAND = 0;
	
	
	boolean aktiverSpieler1Boolean;
	private Spieler spieler1;
	private Spieler spieler2;
	private Kartenstapel kartenstapel;
	private int spieler1KartenanzahlInt;
	private int spieler2KartenanzahlInt;
	private boolean spielende = false;
	
	private BooleanProperty aktiverSpieler1 = new SimpleBooleanProperty();
	
	// Werte der aufgedeckten Karte vom Spieler1
	private StringProperty spieler1Name =  new SimpleStringProperty();
	private StringProperty spieler1Ps =  new SimpleStringProperty();
	private StringProperty spieler1Kmh =  new SimpleStringProperty();
	private StringProperty spieler1Verbrauch =  new SimpleStringProperty();
	private StringProperty spieler1Ccm =  new SimpleStringProperty();	
	private StringProperty spieler1Beschleunigung =  new SimpleStringProperty();
	private StringProperty spieler1JpgUrl =  new SimpleStringProperty();
	
	
	private ObjectProperty<javafx.scene.image.Image> spieler1Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 1 als StringProperty
	private StringProperty spieler1Kartenanzahl = new SimpleStringProperty();
	

	// Werte der aufgedeckten Karte vom Spieler2
	private StringProperty spieler2Name =  new SimpleStringProperty();
	private StringProperty spieler2Ps =  new SimpleStringProperty();
	private StringProperty spieler2Kmh =  new SimpleStringProperty();
	private StringProperty spieler2Verbrauch =  new SimpleStringProperty();
	private StringProperty spieler2Ccm =  new SimpleStringProperty();	
	private StringProperty spieler2Beschleunigung =  new SimpleStringProperty();
	private StringProperty spieler2JpgUrl =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> spieler2Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 2 als StringProperty
	private StringProperty spieler2Kartenanzahl = new SimpleStringProperty();
	
	
	public Spiel () throws RemoteException {
		kartenstapel = new Kartenstapel();
		spieler1 = new Spieler();
		spieler2 = new Spieler();
		
		// Spieler1 beginnt
		// sp�ter �ndern -> nach Zufall
		aktiverSpieler1Boolean= false;
		aktiverSpieler1.setValue(aktiverSpieler1Boolean);

				
		
		
		// sp�ter erstetzen durch eine Funktion der Klasse Spieler, mit der der Spieler
		// ein array mit den Werten der oberen Karte liefert
		// und dann werden die Daten im Spiel aktualisiert bzw. an das ViewModel im Rahmen von updates weiter geschickt
		spieler1Name.bind(spieler1.obereKarteNameProperty());
		spieler1Ps.bind(spieler1.obereKartePsProperty());
		spieler1Kmh.bind(spieler1.obereKarteKmhProperty()); 
		spieler1Verbrauch.bind(spieler1.obereKarteVerbrauchProperty());
		spieler1Ccm.bind(spieler1.obereKarteCcmProperty());
		spieler1Beschleunigung.bind(spieler1.obereKarteBeschleunigungProperty());
		spieler1Img.bind(spieler1.obereKarteImgProperty());
		spieler1JpgUrl.bind(spieler1.obereKarteJpgUrlProperty());
		
		spieler2Name.bind(spieler2.obereKarteNameProperty());
		spieler2Ps.bind(spieler2.obereKartePsProperty());
		spieler2Kmh.bind(spieler2.obereKarteKmhProperty()); 
		spieler2Verbrauch.bind(spieler2.obereKarteVerbrauchProperty());
		spieler2Ccm.bind(spieler2.obereKarteCcmProperty());
		spieler2Beschleunigung.bind(spieler2.obereKarteBeschleunigungProperty());
		spieler2Img.bind(spieler2.obereKarteImgProperty());
		spieler2JpgUrl.bind(spieler2.obereKarteJpgUrlProperty());
		
//		spieler1Ps.bind(spieler1.obereKartePsProperty());
		
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
		System.out.println("kartenMischen()");
		this.kartenstapel.mischen();
	}
	

	private void kartenAusteilen(){
		// List<Karte> list = kartenstapel.getList();
		Spielerstapel spielerstapel [] = kartenstapel.gebeSpielerstapel();
		
		// this.spieler1.hallo();

		this.spieler1.empfangeStapel(spielerstapel[0]);
		this.spieler1.obereKarteAufdecken();
		spieler1KartenanzahlInt = spielerstapel[0].liefereKartenanzahl();
		spieler1Kartenanzahl.setValue(String.valueOf(spieler1KartenanzahlInt)); 
		
		this.spieler2.empfangeStapel(spielerstapel [1]);
		this.spieler2.obereKarteAufdecken();
		spieler2KartenanzahlInt = spielerstapel [1].liefereKartenanzahl();
		spieler2Kartenanzahl.setValue(String.valueOf(spieler2KartenanzahlInt));
		System.out.println();
		System.out.println("kartenAusteilen()");
		System.out.println("Spielerstapel Spieler1:");
		spieler1.AlleKartenAusgeben();
		System.out.println();
		System.out.println("Spielerstapel Spieler2:");
		spieler2.AlleKartenAusgeben();
	}
	
	
	// noch �berlegen, ob auf int verzichten
	public int ermittleRundenergebnis(String attribut) {
		if(!spielende) {
			int rundenergebnis = vergleicheAttribut(attribut);
			this.spielerstapelAktualisieren(rundenergebnis);
			this.aktualisiereAktuellerRundensieger(rundenergebnis);
			System.out.println();
			System.out.println("**************************************************");
			System.out.println("ermittleRundenergebnis() return: " + rundenergebnis);
			System.out.println("spieler1.AlleKartenAusgeben()");
			spieler1.AlleKartenAusgeben();
			System.out.println();
			System.out.println("spieler2.AlleKartenAusgeben()");
			spieler2.AlleKartenAusgeben();
			System.out.println();
			return rundenergebnis;
		} else {
			System.out.println("Spielende: " + spielende);
			return -1;
		}
	}
	
	// AUCHTUNG - NOCH REFACORING -> int ergebnis = liefereVergleichsergebnis(StringProperty1, StringProperty2)
	private int vergleicheAttribut(String attribut){
		System.out.println("vergleicheAttribut() attribut: " + attribut);
		
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
		System.out.println("spielerstapelAktualisieren()");
		
		if (e == SIEGER_SPIELER_1) {
			
			// spieler2
			Karte k = this.spieler2.gebeKarteZurueck();
			System.out.println("Aufruf spieler2.gebeKarteZurueck()");
			spieler2KartenanzahlInt--;
			spieler2Kartenanzahl.setValue(String.valueOf(spieler2KartenanzahlInt));
			
			if (spieler2KartenanzahlInt == 0) {
				spielende = true;
			} else {
				spieler2.obereKarteAufdecken();
			}

			// spieler1
			this.spieler1.empfangeKarte(k);
			System.out.println("Aufruf spieler1.empfangeKarte(k)");
			spieler1KartenanzahlInt++;
			spieler1Kartenanzahl.setValue(String.valueOf(spieler1KartenanzahlInt));
			this.spieler1.verschiebeObereKarteNachUnten();
			spieler1.obereKarteAufdecken();
			
		} else if (e == SIEGER_SPIELER_2){
			
			// spieler1
			Karte k = this.spieler1.gebeKarteZurueck();
			System.out.println("Aufruf spieler1.gebeKarteZurueck()");
			spieler1KartenanzahlInt--;
			spieler1Kartenanzahl.setValue(String.valueOf(spieler1KartenanzahlInt));
			if (spieler1KartenanzahlInt == 0) {
				spielende = true;
			} else {
				spieler1.obereKarteAufdecken();
			}
			
			// spieler2
			this.spieler2.empfangeKarte(k);
			System.out.println("Aufruf spieler2.empfangeKarte(k)");
			spieler2KartenanzahlInt++;
			spieler2Kartenanzahl.setValue(String.valueOf(spieler2KartenanzahlInt));
			this.spieler2.verschiebeObereKarteNachUnten();
			spieler2.obereKarteAufdecken();
		
		} else {
			this.spieler1.verschiebeObereKarteNachUnten();
			spieler1.obereKarteAufdecken();
			this.spieler2.verschiebeObereKarteNachUnten();
			spieler2.obereKarteAufdecken();
		}
		
	}
	
	private void aktualisiereAktuellerRundensieger(int rundenergebnis)  {
		if (rundenergebnis == SIEGER_SPIELER_1) {
			aktiverSpieler1Boolean = true;
		}
		else if (rundenergebnis == SIEGER_SPIELER_2) {
			aktiverSpieler1Boolean = false;
			
		}
		// sp�ter l�schen, wenn wir auf Properties in der Klasse Spiel verzichten
		aktiverSpieler1.setValue(aktiverSpieler1Boolean);
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
	
	
	public StringProperty getSpieler1JpgUrlProperty () {
		return this.spieler1JpgUrl;
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
	
	public StringProperty getSpieler2JpgUrlProperty () {
		return this.spieler2JpgUrl;
	}
	
	
	public BooleanProperty getAktiverSpieler1Boolean () {
			return this.aktiverSpieler1;
	
	}

	
	public StringProperty getSpieler1NameProperty () {
		return this.spieler1Name;
	}
	public StringProperty getSpieler2NameProperty () {
		return this.spieler2Name;
	}
	
	
	public StringProperty getSpieler1KartenanzahlProperty () {
		return this.spieler1Kartenanzahl;
	}
	
	public StringProperty getSpieler2KartenanzahlProperty () {
		return this.spieler2Kartenanzahl;
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