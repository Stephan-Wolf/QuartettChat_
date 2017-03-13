package app;

/**
*  Game.java
*
* @author  Artur Nowodworski
* @version 1.0
* @since   2017/03 
*/

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Game extends UnicastRemoteObject implements IGame {
	
	private static final long serialVersionUID = 1L;
	
	private static final int ROUNDWINNER_PLAYER_1 = 1;
	private static final int ROUNDWINNER_PLAYER_2 = 2;
	private static final int DRAW = 0;
	
	private static final String HP = "ps";
	private static final String KMH = "kmh";
	private static final String CONSUMPTION = "verbrauch";
	private static final String CCM = "ccm";
	private static final String ACCELERATION = "beschleunigung";
	
	private static final String LOST_ROUND = "Runde verloren";
	private static final String WON_ROUND = "Runde gewonnen";
	private static final String DRAWN_ROUND = "Runde untentschieden";
	
	private Player player1;
	private Player player2;
	private GameCardStack cardStack;
	
	private BooleanProperty gameover = new SimpleBooleanProperty();
	private BooleanProperty player1IsActive = new SimpleBooleanProperty();
	private StringProperty player1Status = new SimpleStringProperty();
	private StringProperty player2Status = new SimpleStringProperty();

	
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
		gameover.set(false);
		this.mixCards();
		this.dealCards();
	}
	
	public void repeatGame () {
		
		cardStack = new GameCardStack();
		gameover.set(false);
		this.mixCards();
		this.dealCards();
		this.determineGameInitiator();
		
	}
	
	private void mixCards() {
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

	}
	
	@Override
	public void calculateRoundResult(String cardAttribute) {
		if(gameover.get() == false) {
			int roundResult = compareCardAttributes(cardAttribute);
			this.updatePlayerCardStacks(roundResult);
			this.updateRoundWinner(roundResult);
		}
	}
	
	private int compareCardAttributes(String cardAttributes){
		
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
		
		if (roundResult == ROUNDWINNER_PLAYER_1) {
			this.transferCard(this.player1, this.player2);
			
		} else if (roundResult == ROUNDWINNER_PLAYER_2){
			this.transferCard(this.player2, this.player1);
			
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
			gameover.set(true);
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
			player1Status.setValue(WON_ROUND);
			player2Status.setValue(LOST_ROUND);
			player1IsActive.setValue(true);
		}
		else if (roundResult == ROUNDWINNER_PLAYER_2) {
			player1Status.setValue(LOST_ROUND);
			player2Status.setValue(WON_ROUND);
			player1IsActive.setValue(false);	
		} else {
			player1Status.setValue(DRAWN_ROUND);
			player2Status.setValue(DRAWN_ROUND);
		}
	}
	
	@Override
	public StringProperty players1HpProperty () {
		return this.player1.hpAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty players2HpProperty () {
		return this.player2.hpAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty players1KmhProperty () {
		return this.player1.kmhAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty players2KmhProperty () {
		return this.player2.kmhAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty palyers1ConsumptionProperty () {
		return this.player1.consumptionAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty players2ConsumptionProperty () {
		return this.player2.consumptionAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty players1CcmProperty () {
		return this.player1.ccmAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty players2CcmProperty () {
		return this.player2.ccmAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty players1AccelerationProperty () {
		return this.player1.accelerationAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty players2AccelerationProperty () {
		return this.player2.accelerationAttributeOfTopCardProperty();
	}
	
	@Override
	public StringProperty players1SourceOfJpgProperty () {
		return this.player1.jpgSourceOfTopCardProperty();
	}
	
	@Override
	public StringProperty players2SourceOfJpgProperty () {
		return this.player2.jpgSourceOfTopCardProperty();
	}
	
	@Override
	public StringProperty players1CardNameProperty () {
		return this.player1.nameOfTopCardProperty();
	}
	
	@Override
	public StringProperty players2CardNameProperty () {
		return this.player2.nameOfTopCardProperty();
	}
	
	@Override
	public IntegerProperty players1NumberOfCardsProperty () {
		return this.player1.numberOfCardsProperty();
	}
	
	@Override
	public IntegerProperty players2NumberOfCardsProperty () {
		return this.player2.numberOfCardsProperty();
	}
	
	@Override
	public StringProperty players1StatusProperty () {
		return this.player1Status;
	}
	
	@Override
	public StringProperty players2StatusProperty () {
		return this.player2Status;
	}
	
	@Override
	public BooleanProperty activePlayer1Property () {
		return this.player1IsActive;
	}

	@Override
	public BooleanProperty gameoverProperty() throws RemoteException {
		return this.gameover;
	}
}