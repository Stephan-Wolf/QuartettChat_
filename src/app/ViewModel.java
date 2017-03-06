package app;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
	
	private boolean spieler1Bereit;
	private boolean spieler2Bereit;
	
	
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
	private StringProperty spieler1Status =  new SimpleStringProperty();
	
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
	private StringProperty spieler2Status =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> spieler2Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 2 als StringProperty
	
	private IGame model;
	
		 public ViewModel(IGame model) throws RemoteException {
			 this.model = model;
			 model.startGame();
			 
			 	spieler1Name.bind(model.players1CardNameProperty());
				spieler1Ps.bind(model.players1HpProperty());
				spieler1Kmh.bind(model.players1KmhProperty());
				spieler1Verbrauch.bind(model.palyers1ConsumptionProperty());
				spieler1Ccm.bind(model.players1CcmProperty());
				spieler1Beschleunigung.bind(model.players1AccelerationProperty());
				spieler1Kartenanzahl.bind(model.players1NumberOfCardsProperty());
				spieler1JpgUrl.bind(model.players1SourceOfJpgProperty());
				spieler1Status.bind(model.players1StatusProperty());
				
				spieler2Name.bind(model.players2CardNameProperty());
				spieler2Ps.bind(model.players2HpProperty());
				spieler2Kmh.bind(model.players2KmhProperty());
				spieler2Verbrauch.bind(model.players2ConsumptionProperty());
				spieler2Ccm.bind(model.players2CcmProperty());
				spieler2Beschleunigung.bind(model.players2AccelerationProperty());
				spieler2Kartenanzahl.bind(model.players2NumberOfCardsProperty());
				spieler2JpgUrl.bind(model.players2SourceOfJpgProperty());
				spieler2Status.bind(model.players2StatusProperty());
				
				
				aktiverSpieler1.bind(model.activePlayer1Property());
				System.out.println("Klasse ViewModel - Konstruktor, aktiverSpieler1Property: " + aktiverSpieler1.getValue());
		 }

		 
		 
			public void change (String vergleichsattribut) throws RemoteException {
				
				if(vergleichsattribut.equals(PS)) {
					model.calculateRoundResult(PS);
				} else if (vergleichsattribut.equals(KMH)) {
					model.calculateRoundResult(KMH);
				} else if (vergleichsattribut.equals(VERBRAUCH)) {
					model.calculateRoundResult(VERBRAUCH);
				} else if (vergleichsattribut.equals(CCM)) {
					model.calculateRoundResult(CCM);
				} else if (vergleichsattribut.equals(BESCHLEUNIGUNG)) {
					model.calculateRoundResult(BESCHLEUNIGUNG);
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
				String status = spieler1Status.getValue();
				
				spieler1.update(name, ps, kmh, verbrauch, ccm, beschleunigung, gewinner, kartenanzahl, jpgUrl, status);	
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
				String status = spieler2Status.getValue();
				 
				
				spieler2.update(name, ps, kmh, verbrauch, ccm, beschleunigung, gewinner, kartenanzahl, jpgUrl, status);
				
			}

			@Override
			public void changeChat(String message, int id) throws RemoteException {
				if (id == spieler1.getID()) {
					spieler2.updateChat("Gegner: " + message);
				} else {
					spieler1.updateChat("Gegner: " + message);
				}
				
			}

			@Override
			public void spielStarten() throws RemoteException {
				// TODO Auto-generated method stub
			}

			@Override
			public void spielWiederholen(int id) throws RemoteException {
				if (id == spieler1.getID()) {
					spieler1Bereit = true;
				} else if(id == spieler2.getID()) {
					spieler2Bereit = true;
				}
				if (spieler1Bereit == true && spieler2Bereit == true) {
					model.repeatGame();
					this.updateBeobachter_1();
					this.updateBeobachter_2();
					this.spieler1.updateRestartGame();
					this.spieler2.updateRestartGame();
					spieler1Bereit = false;
					spieler2Bereit = false;
				}
			}



			@Override
			public void spielBeenden(int id) throws RemoteException {
				if (id == spieler1.getID()) {
					spieler2.updateQuitGame();
				} else if (id == spieler2.getID()) {
					spieler1.updateQuitGame();
				}
			}
}
