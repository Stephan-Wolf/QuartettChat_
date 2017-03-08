package app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;

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
	
	private Player player1;
	private Player player2;
	private GameCardStack cardStack;
	private boolean gameover = false;
	
	private BooleanProperty player1IsActive = new SimpleBooleanProperty();
	

	private StringProperty spieler1Status = new SimpleStringProperty();
	
	private StringProperty spieler2Status = new SimpleStringProperty();

	
	public Game () throws RemoteException {
		cardStack = new GameCardStack();
		player1 = new Player();
		player2 = new Player();
		determineGameInitiator();
		
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
	
	public void repeatGame () {
		
		cardStack = new GameCardStack();
		gameover = false;
		this.mixCards();
		this.dealCards();
		this.determineGameInitiator();
		
	}
	
	private void mixCards() {
		System.out.println("kartenMischen()");
		this.cardStack.mix();
	}
	

	private void dealCards(){
		PlayerCardStack playerCardStack [] = cardStack.getPlayerCardStacks();

		this.player1.setPlayerCardStack(playerCardStack[0]);
		player1.updateNumberOfCards();
		this.player1.uncoverTopCard();

		
		this.player2.setPlayerCardStack(playerCardStack [1]);
		player2.updateNumberOfCards();
		this.player2.uncoverTopCard();

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
	

	private void updatePlayerCardStacks(int roundResult) {
		System.out.println("spielerstapelAktualisieren()");
		
		if (roundResult == ROUNDWINNER_PLAYER_1) {
			this.transferCard(this.player1, this.player2);
			
		} else if (roundResult == ROUNDWINNER_PLAYER_2){
			this.transferCard(this.player2, this.player1);
			
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
		Card card = loser.giveCard();
		loser.updateNumberOfCards();
		if (loser.numberOfCardsProperty().getValue() == 0) {
			gameover = true;
		} else {
			loser.uncoverTopCard();
		}

		winner.receiveCard(card);
		winner.updateNumberOfCards();
		winner.moveTopCardDownwards();
		winner.uncoverTopCard();
		
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
	}
	
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
	
	
	public StringProperty players1SourceOfJpgProperty () {
		return this.player1.jpgSourceOfTopCardProperty();
	}
	
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
	
	
	public IntegerProperty players1NumberOfCardsProperty () {
		return this.player1.numberOfCardsProperty();
	}
	
	public IntegerProperty players2NumberOfCardsProperty () {
		return this.player2.numberOfCardsProperty();
	}
	
	public StringProperty players1StatusProperty () {
		return this.spieler1Status;
	}
	
	public StringProperty players2StatusProperty () {
		return this.spieler2Status;
	}
}