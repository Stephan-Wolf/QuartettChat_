package app;


import java.util.Date;
import java.util.Observable;
import java.util.Observer;

//import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;



public class ViewModel extends UnicastRemoteObject  implements IViewModel, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// wenn true, dann spieler1
	// wenn falls dann spieler2
	
	private Beobachter spieler1;
	private Beobachter spieler2;
	
	private BooleanProperty aktiverSpieler1 = new SimpleBooleanProperty();
	
	final String NAME = "name";
	final String PS = "ps";
	final String KMH = "kmh";
	final String VERBRAUCH = "verbrauch";
	final String CCM = "ccm";
	final String BESCHLEUNIGUNG = "beschleunigung";
	
	// Werte der aufgedeckten Karte vom Spieler1
	
	private StringProperty spieler1Name =  new SimpleStringProperty();
	private StringProperty spieler1Ps =  new SimpleStringProperty();
	private StringProperty spieler1Kmh =  new SimpleStringProperty();
	private StringProperty spieler1Verbrauch =  new SimpleStringProperty();
	private StringProperty spieler1Ccm =  new SimpleStringProperty();	
	private StringProperty spieler1Kartenanzahl =  new SimpleStringProperty();
	private StringProperty spieler1Beschleunigung =  new SimpleStringProperty();
	private StringProperty spieler1JpgUrl =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> spieler1Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 1 als StringProperty
	

	// Werte der aufgedeckten Karte vom Spieler2
	private StringProperty spieler2Name =  new SimpleStringProperty();
	private StringProperty spieler2Ps =  new SimpleStringProperty();
	private StringProperty spieler2Kmh =  new SimpleStringProperty();
	private StringProperty spieler2Verbrauch =  new SimpleStringProperty();
	private StringProperty spieler2Ccm =  new SimpleStringProperty();	
	private StringProperty spieler2Beschleunigung =  new SimpleStringProperty();
	private StringProperty spieler2JpgUrl =  new SimpleStringProperty();
	private StringProperty spieler2Kartenanzahl =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> spieler2Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 2 als StringProperty
	
	private IModel model;
	 
	
		 public ViewModel(IModel model) throws RemoteException {
			 this.model = model;
			 model.starten();
			 
			 	spieler1Name.bind(model.getSpieler1NameProperty());
				spieler1Ps.bind(model.getSpieler1PsProperty());
				spieler1Kmh.bind(model.getSpieler1KmhProperty());
				spieler1Verbrauch.bind(model.getSpieler1VerbrauchProperty());
				spieler1Ccm.bind(model.getSpieler1CcmProperty());
				spieler1Beschleunigung.bind(model.getSpieler1BeschleunigungProperty());
				spieler1Kartenanzahl.bind(model.getSpieler1KartenanzahlProperty());
				spieler1JpgUrl.bind(model.getSpieler1JpgUrlProperty());
				
				spieler2Name.bind(model.getSpieler2NameProperty());
				spieler2Ps.bind(model.getSpieler2PsProperty());
				spieler2Kmh.bind(model.getSpieler2KmhProperty());
				spieler2Verbrauch.bind(model.getSpieler2VerbrauchProperty());
				spieler2Ccm.bind(model.getSpieler2CcmProperty());
				spieler2Beschleunigung.bind(model.getSpieler2BeschleunigungProperty());
				spieler2Kartenanzahl.bind(model.getSpieler2KartenanzahlProperty());
				spieler2JpgUrl.bind(model.getSpieler2JpgUrlProperty());
				
				
				aktiverSpieler1.bind(model.getAktiverSpieler1Boolean());
				System.out.println("Klasse ViewModel - Konstruktor, aktiverSpieler1Property: " + aktiverSpieler1.getValue());
		 }

		 
		 
			public void change (String vergleichsattribut) throws RemoteException {
				
				if(vergleichsattribut.equals(PS)) {
					model.ermittleRundenergebnis(PS);
				} else if (vergleichsattribut.equals(KMH)) {
					model.ermittleRundenergebnis(KMH);
				} else if (vergleichsattribut.equals(VERBRAUCH)) {
					model.ermittleRundenergebnis(VERBRAUCH);
				} else if (vergleichsattribut.equals(CCM)) {
					model.ermittleRundenergebnis(CCM);
				} else if (vergleichsattribut.equals(BESCHLEUNIGUNG)) {
					model.ermittleRundenergebnis(BESCHLEUNIGUNG);
				}	
				System.out.println("ViewModel: change()");
				this.updateBeobachter_1();
				this.updateBeobachter_2();
			}

			@Override
			public void setBeobachter_1(Beobachter beobachter) throws RemoteException {
				spieler1 = beobachter;
				updateBeobachter_1();
				
			}
			
			@Override
			public void setBeobachter_2(Beobachter beobachter) throws RemoteException {
				spieler2 = beobachter;
				updateBeobachter_2();
				
			}
			
			void updateBeobachter_1() throws RemoteException {
				String name = spieler1Name.getValue();
				String ps = spieler1Ps.getValue();
				String kmh 	= spieler1Kmh.getValue();
				String verbrauch= spieler1Verbrauch.getValue();
				String ccm = spieler1Ccm.getValue();
				String beschleunigung = spieler1Beschleunigung.getValue();
				boolean gewinner = aktiverSpieler1.getValue();
				String kartenanzahl = spieler1Kartenanzahl.getValue();
				String jpgUrl = spieler1JpgUrl.getValue();
				
				
				spieler1.update(name, ps, kmh, verbrauch, ccm, beschleunigung, gewinner, kartenanzahl, jpgUrl);	
				
			}
			void updateBeobachter_2() throws RemoteException { 
				String name = spieler2Name.getValue();
				String ps = spieler2Ps.getValue();
				String kmh 	= spieler2Kmh.getValue();
				String verbrauch= spieler2Verbrauch.getValue();
				String ccm = spieler2Ccm.getValue();
				String beschleunigung = spieler2Beschleunigung.getValue();
				boolean gewinner =! aktiverSpieler1.getValue();
				String kartenanzahl = spieler2Kartenanzahl.getValue();
				String jpgUrl = spieler2JpgUrl.getValue();
				
				spieler2.update(name, ps, kmh, verbrauch, ccm, beschleunigung, gewinner, kartenanzahl, jpgUrl);
				
			}
}
