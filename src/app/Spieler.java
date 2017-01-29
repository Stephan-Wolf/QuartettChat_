package app;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class Spieler {
	
	private StringProperty obereKarteName = new SimpleStringProperty();
	private StringProperty obereKartePs = new SimpleStringProperty();
	private StringProperty obereKarteKmh =  new SimpleStringProperty();
	private StringProperty obereKarteVerbrauch =  new SimpleStringProperty();
	private StringProperty obereKarteCcm =  new SimpleStringProperty();	
	private StringProperty obereKarteBeschleunigung =  new SimpleStringProperty();
	private StringProperty obereKarteJpgUrl =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> obereKarteImg = new SimpleObjectProperty<>();
	
	//jgpUrlProperty
	// public?? brauchen wir die Variable?
	// public Karte obereKarte;
	private Spielerstapel spielerstapel = new Spielerstapel();
	private int spielerId;
	private boolean hatKarte;
	private boolean connencted;
	
	
	public Spieler () {
	}
	
	// TEstMEthode
	public void AlleKartenAusgeben() {
		spielerstapel.zeigeKarten();
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
		obereKarteName.setValue(obereKarte.getNameProperty().getValue());
		obereKartePs.setValue(obereKarte.getPsProperty().getValue());
		obereKarteKmh.setValue(obereKarte.getKmhProperty().getValue());
		obereKarteVerbrauch.setValue(obereKarte.getVerbrauchProperty().getValue());  
		obereKarteCcm.setValue(obereKarte.getCcmProperty().getValue());
		obereKarteBeschleunigung.setValue(obereKarte.getBeschleunigungProperty().getValue());
		obereKarteJpgUrl.setValue(obereKarte.getJgpUrlProperty().getValue());
		obereKarteImg.setValue(obereKarte.getImageProperty().getValue());
		
	}
	
	
	public final StringProperty obereKartePsProperty () {
        if (obereKartePs == null) { 
        	obereKartePs = new SimpleStringProperty(""); 
        } 
        return obereKartePs; 
	}
	
	public StringProperty obereKarteKmhProperty() {
		return this.obereKarteKmh;
	}
	
	public StringProperty obereKarteVerbrauchProperty() {
		return this.obereKarteVerbrauch;
	}
	
	public StringProperty obereKarteCcmProperty() {
		return this.obereKarteCcm;
	}
	
	public StringProperty obereKarteBeschleunigungProperty() {
		return this.obereKarteBeschleunigung;
	}
	
	public ObjectProperty<javafx.scene.image.Image> obereKarteImgProperty () {
		return this.obereKarteImg;
	}

	
	public StringProperty obereKarteNameProperty() {
		return this.obereKarteName;
	}

	public StringProperty obereKarteJpgUrlProperty() {
		return this.obereKarteJpgUrl;
	}
	
}
