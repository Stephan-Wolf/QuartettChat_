package app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.BooleanProperty;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Game extends UnicastRemoteObject implements IGame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int ROUNDWINNER_PLAYER_1 = 1;
	private static final int ROUNDWINNER_PLAYER_2 = 2;
	private static final int DRAW = 0;
	
	final String HP = "ps";
	final String KMH = "kmh";
	final String CONSUMPTION = "verbrauch";
	final String CCM = "ccm";
	final String ACCELERATION = "beschleunigung";
	
	// boolean aktiverSpieler1Boolean;
	private Player player1;
	private Player player2;
	private GameCardStack cardStack;
	private int players1NumberOfCards;
	private int players2NumberOfCards;
	private boolean gameover = false;
	
	private BooleanProperty player1IsActive = new SimpleBooleanProperty();
	
	// Werte der aufgedeckten Karte vom Spieler1
	// private StringProperty spieler1Name =  new SimpleStringProperty();
	// private StringProperty spieler1Ps =  new SimpleStringProperty();
	// private StringProperty spieler1Kmh =  new SimpleStringProperty();
	// private StringProperty spieler1Verbrauch =  new SimpleStringProperty();
	// private StringProperty spieler1Ccm =  new SimpleStringProperty();	
	// private StringProperty spieler1Beschleunigung =  new SimpleStringProperty();
	// private StringProperty spieler1JpgUrl =  new SimpleStringProperty();
	private StringProperty spieler1Status = new SimpleStringProperty();
	
	
	// private ObjectProperty<javafx.scene.image.Image> spieler1Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 1 als StringProperty
	private StringProperty spieler1Kartenanzahl = new SimpleStringProperty();
	

	// Werte der aufgedeckten Karte vom Spieler2
	// private StringProperty spieler2Name =  new SimpleStringProperty();
	// private StringProperty spieler2Ps =  new SimpleStringProperty();
	// private StringProperty spieler2Kmh =  new SimpleStringProperty();
	// private StringProperty spieler2Verbrauch =  new SimpleStringProperty();
	// private StringProperty spieler2Ccm =  new SimpleStringProperty();	
	// private StringProperty spieler2Beschleunigung =  new SimpleStringProperty();
	// private StringProperty spieler2JpgUrl =  new SimpleStringProperty();
	private StringProperty spieler2Status = new SimpleStringProperty();

	// private ObjectProperty<javafx.scene.image.Image> spieler2Img = new SimpleObjectProperty<>();
	// Anzahl der Karten vom Spieler 2 als StringProperty
	private StringProperty spieler2Kartenanzahl = new SimpleStringProperty();
	
	
	public Game () throws RemoteException {
		cardStack = new GameCardStack();
		player1 = new Player();
		player2 = new Player();
		determineGameInitiator();
		// Spieler1 beginnt
		// sp�ter �ndern -> nach Zufall
		//random math #
		// Rafactoring, in eine Methode packen, verk�rzen
		// activePlayer1.setValue(aktiverSpieler1Boolean);
				
		
		
		// sp�ter erstetzen durch eine Funktion der Klasse Spieler, mit der der Spieler
		// ein array mit den Werten der oberen Karte liefert
		// und dann werden die Daten im Spiel aktualisiert bzw. an das ViewModel im Rahmen von updates weiter geschickt
		// spieler1Name.bind(spieler1.obereKarteNameProperty());
		// spieler1Ps.bind(spieler1.obereKartePsProperty());
		// spieler1Kmh.bind(spieler1.obereKarteKmhProperty()); 
		// spieler1Verbrauch.bind(spieler1.obereKarteVerbrauchProperty());
		// spieler1Ccm.bind(spieler1.obereKarteCcmProperty());
		// spieler1Beschleunigung.bind(spieler1.obereKarteBeschleunigungProperty());
		// spieler1Img.bind(spieler1.obereKarteImgProperty());
		// spieler1JpgUrl.bind(spieler1.obereKarteJpgUrlProperty());
		
		// spieler2Name.bind(spieler2.obereKarteNameProperty());
		// spieler2Ps.bind(spieler2.obereKartePsProperty());
		// spieler2Kmh.bind(spieler2.obereKarteKmhProperty()); 
		// spieler2Verbrauch.bind(spieler2.obereKarteVerbrauchProperty());
		// spieler2Ccm.bind(spieler2.obereKarteCcmProperty());
		// spieler2Beschleunigung.bind(spieler2.obereKarteBeschleunigungProperty());
		// spieler2Img.bind(spieler2.obereKarteImgProperty());
		// spieler2JpgUrl.bind(spieler2.obereKarteJpgUrlProperty());
		
//		spieler1Ps.bind(spieler1.obereKartePsProperty());
		
	}
	
	private void determineGameInitiator () {
		int randomNumber = (int)(Math.random() * 2 + 1);
		if (randomNumber == 1){
			player1IsActive.setValue(true);;
		}
		else {
			player1IsActive.setValue(false);
		}
	}
	
	public void startGame () {
		gameover = false;
		this.mixCards();
		this.dealCards();
	}
	
	// ???????????
	public void repeatGame () {
		
		// zuerst die alten  Kartenstapel-Objekt, Spielerstapel-Objekte l�schen?
		cardStack = new GameCardStack();
		gameover = false;
		this.mixCards();
		this.dealCards();
		this.determineGameInitiator();
		// Spieler1 beginnt
		// sp�ter �ndern -> nach Zufall
		//random math #
		// Rafactoring, in eine Methode packen, verk�rzen
//		int randomNumber;
//	    randomNumber = (int)(Math.random() * 2+1);
//	    System.out.println(randomNumber);
//	    
//		if (randomNumber == 1){
//			aktiverSpieler1Boolean = false;
//		}
//		else{
//			aktiverSpieler1Boolean = true;
//		}
//		activePlayer1.setValue(aktiverSpieler1Boolean);
		
	}
	
	private void mixCards() {
		System.out.println("kartenMischen()");
		this.cardStack.mix();
	}
	

	private void dealCards(){
		PlayerCardStack playerCardStack [] = cardStack.getPlayerCardStacks();

		this.player1.setPlayerCardStack(playerCardStack[0]);
		this.player1.uncoverTopCard();
		players1NumberOfCards = playerCardStack[0].getNumberOfCards();
		spieler1Kartenanzahl.setValue(String.valueOf(players1NumberOfCards)); 
		
		this.player2.setPlayerCardStack(playerCardStack [1]);
		this.player2.uncoverTopCard();
		players2NumberOfCards = playerCardStack [1].getNumberOfCards();
		spieler2Kartenanzahl.setValue(String.valueOf(players2NumberOfCards));
		System.out.println();
		System.out.println("kartenAusteilen()");
		System.out.println("Spielerstapel Spieler1:");
		player1.printAllCards();
		System.out.println();
		System.out.println("Spielerstapel Spieler2:");
		player2.printAllCards();
	}
	
	
	// noch �berlegen, ob auf int verzichten
	public int calculateRoundResult(String cardAttribute) {
		if(gameover == false) {
			int roundResult = compareCardAttributes(cardAttribute);
			this.updatePlayerCardStacks(roundResult);
			this.updateRoundWinner(roundResult);
			System.out.println();
			System.out.println("**************************************************");
			System.out.println("ermittleRundenergebnis() return: " + roundResult);
			System.out.println("spieler1.AlleKartenAusgeben()");
			player1.printAllCards();
			System.out.println();
			System.out.println("spieler2.AlleKartenAusgeben()");
			player2.printAllCards();
			System.out.println();
			return roundResult;
		} else {
			System.out.println("Spielende: " + gameover);
			return -1;
		}
	}
	
	// AUCHTUNG - NOCH REFACORING -> int ergebnis = liefereVergleichsergebnis(StringProperty1, StringProperty2)
	private int compareCardAttributes(String cardAttributes){
		System.out.println("vergleicheAttribut() attribut: " + cardAttributes);
		
		if(cardAttributes.equals(HP)) {
			
			int result = getComparingResult(player1.hpAttributeOfTopCardProperty(), player2.hpAttributeOfTopCardProperty());
			
			return result;
			
		} else if(cardAttributes.equals(KMH)) {
			
			int result = getComparingResult(player1.kmhAttributeOfTopCardProperty(), player2.kmhAttributeOfTopCardProperty());
			return result;
			
		} else if(cardAttributes.equals(CONSUMPTION)) {
			
			int result = getComparingResult(player2.consumptionAttributeOfTopCardProperty(), player1.consumptionAttributeOfTopCardProperty());
			
			return result;
			
		} else if(cardAttributes.equals(CCM)) {
			
			int result = getComparingResult(player1.ccmAttributeOfTopCardProperty(), player2.ccmAttributeOfTopCardProperty());
			return result;
			
		} else if(cardAttributes.equals(ACCELERATION)) {
			
			int result = getComparingResult(player2.accelerationAttributeOfTopCardProperty(), player1.accelerationAttributeOfTopCardProperty());
			return result;
		}
		
		return 0;
	}
	

	
	private int getComparingResult(StringProperty cardAttribute1, StringProperty cardAttribute2) {
		float comparingFloatingPointNumber1 = Float.parseFloat(cardAttribute1.getValue());
		float comparingFloatingPointNumber2 = Float.parseFloat(cardAttribute2.getValue());
		
		if (comparingFloatingPointNumber1 > comparingFloatingPointNumber2) {
			return ROUNDWINNER_PLAYER_1;
		} else if (comparingFloatingPointNumber2 > comparingFloatingPointNumber1) {
			return ROUNDWINNER_PLAYER_2;
		}
		else { 
			return DRAW;
		}
	}
	
//	private int liefereVergleichsergebnisKleiner(StringProperty attributwert1, StringProperty attributwert2) {
//		float attributwert1Float = Float.parseFloat(attributwert1.getValue());
//		float attributwert2Float = Float.parseFloat(attributwert2.getValue());
//		
//		if (attributwert1Float < attributwert2Float) {
//			return ROUNDWINNER_PLAYER_1;
//		} else if (attributwert2Float < attributwert1Float) {
//			return ROUNDWINNER_PLAYER_2;
//		}
//		else { 
//			return DRAW;
//		}
//	}
	
	// Refactoring??
	private void updatePlayerCardStacks(int roundResult) {
		System.out.println("spielerstapelAktualisieren()");
		
		if (roundResult == ROUNDWINNER_PLAYER_1) {
			
			// spieler2
			Card karte = this.player2.giveCard();
			System.out.println("Aufruf spieler2.gebeKarteZurueck()");
			players2NumberOfCards--;
			spieler2Kartenanzahl.setValue(String.valueOf(players2NumberOfCards));
			
			if (players2NumberOfCards == 0) {
				gameover = true;
			} else {
				player2.uncoverTopCard();
			}

			// spieler1
			this.player1.receiveCard(karte);
			System.out.println("Aufruf spieler1.empfangeKarte(k)");
			players1NumberOfCards++;
			spieler1Kartenanzahl.setValue(String.valueOf(players1NumberOfCards));
			this.player1.moveTopCardDownwards();
			player1.uncoverTopCard();
			
		} else if (roundResult == ROUNDWINNER_PLAYER_2){
			
			// spieler1
			Card k = this.player1.giveCard();
			System.out.println("Aufruf spieler1.gebeKarteZurueck()");
			players1NumberOfCards--;
			spieler1Kartenanzahl.setValue(String.valueOf(players1NumberOfCards));
			if (players1NumberOfCards == 0) {
				
				gameover = true;
			} else {
				player1.uncoverTopCard();
			}
			
			// spieler2
			this.player2.receiveCard(k);
			System.out.println("Aufruf spieler2.empfangeKarte(k)");
			players2NumberOfCards++;
			spieler2Kartenanzahl.setValue(String.valueOf(players2NumberOfCards));
			this.player2.moveTopCardDownwards();
			player2.uncoverTopCard();
		}else if (roundResult == ROUNDWINNER_PLAYER_1 && gameover == true){
			System.out.println("SPiel Over und Gewinner ist Spieler 1");
		}else if (roundResult == ROUNDWINNER_PLAYER_2 && gameover == true){
			System.out.println("SPiel Over und Gewinner ist Spieler 2");
		} else {
			this.player1.moveTopCardDownwards();
			player1.uncoverTopCard();
			this.player2.moveTopCardDownwards();
			player2.uncoverTopCard();
		}
	}
	
	private void transferCard (Player winner, Player loser) {
		
	}
	
	private void updateRoundWinner(int roundResult)  {
		if (roundResult == ROUNDWINNER_PLAYER_1) {
			spieler1Status.setValue("Runde gewonnen");
			spieler2Status.setValue("Runde verloren");
			player1IsActive.setValue(true);
		}
		else if (roundResult == ROUNDWINNER_PLAYER_2) {
			spieler1Status.setValue("Runde verloren");
			spieler2Status.setValue("Runde gewonnen");
			player1IsActive.setValue(false);	
		}
		// sp�ter l�schen, wenn wir auf Properties in der Klasse Spiel verzichten
	}
	
	
	// Refactoring??? read only??
	public StringProperty players1HpProperty () {
		return this.player1.hpAttributeOfTopCardProperty();
	}
	
	public StringProperty players1KmhProperty () {
		return this.player1.kmhAttributeOfTopCardProperty();
	}
	
	public StringProperty palyers1ConsumptionProperty () {
		return this.player1.consumptionAttributeOfTopCardProperty();
	}
	
	public StringProperty players1CcmProperty () {
		return this.player1.ccmAttributeOfTopCardProperty();
	}
	
	public StringProperty players1AccelerationProperty () {
		return this.player1.accelerationAttributeOfTopCardProperty();
	}
	
	
//	public ObjectProperty<javafx.scene.image.Image> getSpieler1Img () {
//		return this.spieler1Img;
//	}
	
	
	public StringProperty players1SourceOfJpgProperty () {
		return this.player1.jpgSourceOfTopCardProperty();
	}
	
	
	// Refactoring??? read only??
	public StringProperty players2HpProperty () {
		return this.player2.hpAttributeOfTopCardProperty();
	}
	
	public StringProperty players2KmhProperty () {
		return this.player2.kmhAttributeOfTopCardProperty();
	}
	
	public StringProperty players2ConsumptionProperty () {
		return this.player2.consumptionAttributeOfTopCardProperty();
	}
	
	public StringProperty players2CcmProperty () {
		return this.player2.ccmAttributeOfTopCardProperty();
	}
	
	public StringProperty players2AccelerationProperty () {
		return this.player2.accelerationAttributeOfTopCardProperty();
	}
	
//	public ObjectProperty<javafx.scene.image.Image> getSpieler2Img () {
//		return this.spieler2Img;
//	}
	
	public StringProperty players2SourceOfJpgProperty () {
		return this.player2.jpgSourceOfTopCardProperty();
	}
	
	
	public BooleanProperty activePlayer1Property () {
			return this.player1IsActive;
	
	}

	
	public StringProperty players1CardNameProperty () {
		return this.player1.nameOfTopCardProperty();
	}
	
	public StringProperty players2CardNameProperty () {
		return this.player2.nameOfTopCardProperty();
	}
	
	
	public StringProperty players1NumberOfCardsProperty () {
		return this.spieler1Kartenanzahl;
	}
	
	public StringProperty players2NumberOfCardsProperty () {
		return this.spieler2Kartenanzahl;
	}
	
	public StringProperty players1StatusProperty () {
		return this.spieler1Status;
	}
	
	public StringProperty players2StatusProperty () {
		return this.spieler2Status;
	}
}