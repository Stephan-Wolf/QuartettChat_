package app;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
	
	private Beobachter player1;
	private Beobachter player2;
	
	private boolean player1Ready;
	private boolean player2Ready;
	
	
	private BooleanProperty aktiverSpieler1 = new SimpleBooleanProperty();
	
//	final String NAME = "name";
//	final String PS = "ps";
//	final String KMH = "kmh";
//	final String VERBRAUCH = "verbrauch";
//	final String CCM = "ccm";
//	final String BESCHLEUNIGUNG = "beschleunigung";
	
	// Werte der aufgedeckten Karte vom Spieler1
	
	private StringProperty spieler1Name =  new SimpleStringProperty();
	private StringProperty spieler1Ps =  new SimpleStringProperty();
	private StringProperty spieler1Kmh =  new SimpleStringProperty();
	private StringProperty spieler1Verbrauch =  new SimpleStringProperty();
	private StringProperty spieler1Ccm =  new SimpleStringProperty();	
	private IntegerProperty spieler1Kartenanzahl =  new SimpleIntegerProperty();
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
	private IntegerProperty spieler2Kartenanzahl =  new SimpleIntegerProperty();
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
				model.calculateRoundResult(vergleichsattribut);
				
//				if(vergleichsattribut.equals(PS)) {
//					model.calculateRoundResult(PS);
//				} else if (vergleichsattribut.equals(KMH)) {
//					model.calculateRoundResult(KMH);
//				} else if (vergleichsattribut.equals(VERBRAUCH)) {
//					model.calculateRoundResult(VERBRAUCH);
//				} else if (vergleichsattribut.equals(CCM)) {
//					model.calculateRoundResult(CCM);
//				} else if (vergleichsattribut.equals(BESCHLEUNIGUNG)) {
//					model.calculateRoundResult(BESCHLEUNIGUNG);
//				}	
				System.out.println("ViewModel: change()");
				this.updateBeobachter_1();
				this.updateBeobachter_2();
			}

			@Override
			public void setBeobachter_1(Beobachter beobachter) throws RemoteException {
				player1 = beobachter;
				updateBeobachter_1();
				
			}
			
			@Override
			public void setBeobachter_2(Beobachter beobachter) throws RemoteException {
				player2 = beobachter;
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
				int numberofCards = spieler1Kartenanzahl.getValue();
				String jpgUrl = spieler1JpgUrl.getValue();
				String status = spieler1Status.getValue();
				
				player1.update(name, ps, kmh, verbrauch, ccm, beschleunigung, gewinner, numberofCards, jpgUrl, status);	
			}
			
			void updateBeobachter_2() throws RemoteException { 
				String name = spieler2Name.getValue();
				String ps = spieler2Ps.getValue();
				String kmh 	= spieler2Kmh.getValue();
				String verbrauch= spieler2Verbrauch.getValue();
				String ccm = spieler2Ccm.getValue();
				String beschleunigung = spieler2Beschleunigung.getValue();
				boolean gewinner =! aktiverSpieler1.getValue();
				int numberofCards = spieler2Kartenanzahl.getValue();
				String jpgUrl = spieler2JpgUrl.getValue();
				String status = spieler2Status.getValue();
				 
				
				player2.update(name, ps, kmh, verbrauch, ccm, beschleunigung, gewinner, numberofCards, jpgUrl, status);
				
			}

			@Override
			public void changeChat(String message, int id) throws RemoteException {
				if (id == player1.getID()) {
					player2.updateChat("Gegner: " + message);
				} else {
					player1.updateChat("Gegner: " + message);
				}
				
			}

			@Override
			public void spielStarten() throws RemoteException {
				// TODO Auto-generated method stub
			}

			@Override
			public void restartGame(int id) throws RemoteException {
				if (id == player1.getID()) {
					player1Ready = true;
				} else if(id == player2.getID()) {
					player2Ready = true;
				}
				if (player1Ready == true && player2Ready == true) {
					model.repeatGame();
					this.updateBeobachter_1();
					this.updateBeobachter_2();
					this.player1.updateRestartGame();
					this.player2.updateRestartGame();
					player1Ready = false;
					player2Ready = false;
				}
			}



			@Override
			public void quitGame(int id) throws RemoteException {
				if (id == player1.getID()) {
					player2.updateQuitGame();
				} else if (id == player2.getID()) {
					player1.updateQuitGame();
				}
			}
}
