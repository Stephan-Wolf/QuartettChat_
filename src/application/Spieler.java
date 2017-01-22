package application;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Spieler {
	
	private StringProperty obereKartePs =  new SimpleStringProperty();
	private StringProperty obereKarteKmh =  new SimpleStringProperty();
	private StringProperty obereKarteVerbrauch =  new SimpleStringProperty();
	private StringProperty obereKarteCcm =  new SimpleStringProperty();	
	private StringProperty obereKarteBeschleunigung =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> obereKarteImg = new SimpleObjectProperty<>();
	
	
	// public?? brauchen wir die Variable?
	// public Karte obereKarte;
	private Spielerstapel spielerstapel = new Spielerstapel();
	private int spielerId;
	private boolean hatKarte;
	private boolean connencted;
	
	
	public Spieler () {
	}
	
	public void empfangeKarte(Karte karte){
		spielerstapel.fuegeKarteUntenHinzu(karte);
	}
	
	public void empfangeStapel(Spielerstapel s){
		spielerstapel = s;
	}
	
	public Karte gebeKarteZurueck(){
		return spielerstapel.entferneKarte();
	}

	public void verschiebeObereKarteNachUnten() {
		Karte k = spielerstapel.entferneKarte();
		spielerstapel.fuegeKarteUntenHinzu(k);
		
	}
	
	public void obereKarteAufdecken() {
		Karte obereKarte =  spielerstapel.gebeObereKarte();
		
		obereKartePs = obereKarte.getPsProperty();
		obereKarteKmh = obereKarte.getKmhProperty();
		obereKarteVerbrauch = obereKarte.getVerbrauchProperty();  
		obereKarteCcm = obereKarte.getCcmProperty();
		obereKarteBeschleunigung = obereKarte.getBeschleunigungProperty();
		obereKarteImg = obereKarte.getImageProperty();
		
	}
	
	
	public StringProperty getObereKartePs () {
		return this.obereKartePs;
	}
	
	public StringProperty getObereKarteKmh() {
		return this.obereKarteKmh;
	}
	
	public StringProperty getObereKarteVerbrauch() {
		return this.obereKarteVerbrauch;
	}
	
	public StringProperty getObereKarteCcm() {
		return this.obereKarteCcm;
	}
	
	public StringProperty getObereKarteBeschleunigung() {
		return this.obereKarteBeschleunigung;
	}
	
	public ObjectProperty<javafx.scene.image.Image> getObereKarteImg () {
		return this.obereKarteImg;
	}
	
	// test
	public void hallo () {
		System.out.print("Hallo");
	}
	
}
