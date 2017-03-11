package app;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.io.Serializable;

public class ViewModel extends UnicastRemoteObject  implements IViewModel, Serializable{

	private static final long serialVersionUID = 1L;
	private Observer player1;
	private Observer player2;
	private boolean player1Ready;
	private boolean player2Ready;
	
	private BooleanProperty isPlayer1Active = new SimpleBooleanProperty();
	
	
	/**
	 * All the variables for both players
	 */
	private StringProperty players1CardName =  new SimpleStringProperty();
	private StringProperty players1SourceOfJpg =  new SimpleStringProperty();
	private StringProperty players1Hp =  new SimpleStringProperty();
	private StringProperty players1Kmh =  new SimpleStringProperty();
	private StringProperty palyers1Consumption =  new SimpleStringProperty();
	private StringProperty players1Ccm =  new SimpleStringProperty();	
	private StringProperty players1Acceleration =  new SimpleStringProperty();
	private StringProperty players1Status =  new SimpleStringProperty();
	private IntegerProperty players1NumberOfCards =  new SimpleIntegerProperty();

	private StringProperty players2CardName =  new SimpleStringProperty();
	private StringProperty players2SourceOfJpg =  new SimpleStringProperty();
	private StringProperty players2Hp =  new SimpleStringProperty();
	private StringProperty players2Kmh =  new SimpleStringProperty();
	private StringProperty players2Consumption =  new SimpleStringProperty();
	private StringProperty players2Ccm =  new SimpleStringProperty();	
	private StringProperty players2Acceleration =  new SimpleStringProperty();
	private StringProperty players2Status =  new SimpleStringProperty();
	private IntegerProperty players2NumberOfCards =  new SimpleIntegerProperty();
	
	private IGame model;
	
	public ViewModel(IGame model) throws RemoteException {
		this.model = model;
		model.startGame();
		 
	 	players1CardName.bind(model.players1CardNameProperty());
		players1Hp.bind(model.players1HpProperty());
		players1Kmh.bind(model.players1KmhProperty());
		palyers1Consumption.bind(model.palyers1ConsumptionProperty());
		players1Ccm.bind(model.players1CcmProperty());
		players1Acceleration.bind(model.players1AccelerationProperty());
		players1NumberOfCards.bind(model.players1NumberOfCardsProperty());
		players1SourceOfJpg.bind(model.players1SourceOfJpgProperty());
		players1Status.bind(model.players1StatusProperty());
		
		players2CardName.bind(model.players2CardNameProperty());
		players2Hp.bind(model.players2HpProperty());
		players2Kmh.bind(model.players2KmhProperty());
		players2Consumption.bind(model.players2ConsumptionProperty());
		players2Ccm.bind(model.players2CcmProperty());
		players2Acceleration.bind(model.players2AccelerationProperty());
		players2NumberOfCards.bind(model.players2NumberOfCardsProperty());
		players2SourceOfJpg.bind(model.players2SourceOfJpgProperty());
		players2Status.bind(model.players2StatusProperty());
		
		isPlayer1Active.bind(model.activePlayer1Property());
	}
	
	/**
	 * Triggers the Model when one step in the game happens
	 *
	 * @param comparisonAttribute one of the Attributes of a Card (Hp, Kmh, Consumption, CCm or Acceleration)
	 */
	public void change (String comparisonAttribute) throws RemoteException {
		model.calculateRoundResult(comparisonAttribute);
		this.updateObserver(1);
		this.updateObserver(2);
	}

	@Override
	public void setObserver1(Observer observer) throws RemoteException {
		player1 = observer;
		updateObserver(1);
	}
	
	@Override
	public void setObserver2(Observer observer) throws RemoteException {
		player2 = observer;
		updateObserver(2);
	}
	
	void updateObserver(int x) throws RemoteException {
		if(x==1){
			String name = players1CardName.getValue();
			String hp = players1Hp.getValue();
			String kmh 	= players1Kmh.getValue();
			String consumption= palyers1Consumption.getValue();
			String ccm = players1Ccm.getValue();
			String acceleration = players1Acceleration.getValue();
			boolean winner = isPlayer1Active.getValue();
			int numberOfCards = players1NumberOfCards.getValue();
			String jpgUrl = players1SourceOfJpg.getValue();
			String status = players1Status.getValue();
			
			player1.update(name, hp, kmh, consumption, ccm, acceleration, winner, numberOfCards, jpgUrl, status);	
		}
		if(x==2){
			String name = players2CardName.getValue();
			String hp = players2Hp.getValue();
			String kmh 	= players2Kmh.getValue();
			String consumption= players2Consumption.getValue();
			String ccm = players2Ccm.getValue();
			String acceleration = players2Acceleration.getValue();
			boolean winner =! isPlayer1Active.getValue();
			int numberOfCards = players2NumberOfCards.getValue();
			String jpgUrl = players2SourceOfJpg.getValue();
			String status = players2Status.getValue();
			
			player2.update(name, hp, kmh, consumption, ccm, acceleration, winner, numberOfCards, jpgUrl, status);
		}
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
	public void restartGame(int id) throws RemoteException {
		if (id == player1.getID()) {
			player1Ready = true;
		} else if(id == player2.getID()) {
			player2Ready = true;
		}
		if (player1Ready == true && player2Ready == true) {
			model.repeatGame();
			this.updateObserver(1);
			this.updateObserver(2);
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
