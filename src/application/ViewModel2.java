package application;


import java.util.Date;
import java.util.Observable;
import java.util.Observer;

//import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class ViewModel2 {

	
	// Werte der aufgedeckten Karte vom Spieler1
	private StringProperty spieler1Ps =  new SimpleStringProperty();
	private StringProperty spieler1Kmh =  new SimpleStringProperty();
	private StringProperty spieler1Verbrauch =  new SimpleStringProperty();
	private StringProperty spieler1Ccm =  new SimpleStringProperty();	
	private StringProperty spieler1Beschleunigung =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> spieler1Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 1 als StringProperty
	

	// Werte der aufgedeckten Karte vom Spieler2
	private StringProperty spieler2Ps =  new SimpleStringProperty();
	private StringProperty spieler2Kmh =  new SimpleStringProperty();
	private StringProperty spieler2Verbrauch =  new SimpleStringProperty();
	private StringProperty spieler2Ccm =  new SimpleStringProperty();	
	private StringProperty spieler2Beschleunigung =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> spieler2Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 2 als StringProperty
	
	private Spiel model;
	 
		// Konstruktor
		public ViewModel2() {
			
		}
	
	
//		 public ViewModel2(Spiel model) {
//			 this.model = model;
//			 
//				spieler1Ps.bind(model.getSpieler1PsProperty());
//				spieler1Kmh.bind(model.getSpieler1KmhProperty());
//				spieler1Verbrauch.bind(model.getSpieler1VerbrauchProperty());
//				spieler1Ccm.bind(model.getSpieler1CcmProperty());
//				spieler1Beschleunigung.bind(model.getSpieler1BeschleunigungProperty());
//				spieler1Img.bind(model.getSpieler1Img());
//				
//				spieler2Ps.bind(model.getSpieler2PsProperty());
//				spieler2Kmh.bind(model.getSpieler2KmhProperty());
//				spieler2Verbrauch.bind(model.getSpieler2VerbrauchProperty());
//				spieler2Ccm.bind(model.getSpieler2CcmProperty());
//				spieler2Beschleunigung.bind(model.getSpieler2BeschleunigungProperty());
//				spieler2Img.bind(model.getSpieler2Img()); 
//		 }

		 
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
