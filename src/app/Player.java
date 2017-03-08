package app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Player {
	
	private StringProperty nameOfTopCard = new SimpleStringProperty();
	private StringProperty hpAttributeOfTopCard = new SimpleStringProperty();
	private StringProperty kmhAttributeOfTopCard =  new SimpleStringProperty();
	private StringProperty consumptionAttributeOfTopCard =  new SimpleStringProperty();
	private StringProperty ccmAttributeOfTopCard =  new SimpleStringProperty();	
	private StringProperty accelerationAttributeOfTopCard =  new SimpleStringProperty();
	private StringProperty jpgSourceOfTopCard =  new SimpleStringProperty();
	// private ObjectProperty<javafx.scene.image.Image> obereKarteImg = new SimpleObjectProperty<>();
	
	//jgpUrlProperty
	// public?? brauchen wir die Variable?
	// public Karte obereKarte;
	private PlayerCardStack playerCardStack = new PlayerCardStack();
//	private int spielerId;
//	private boolean hatKarte;
//	private boolean connencted;
	
	
	public Player () {
	}
	
	// TEstMEthode
	public void printAllCards() {
		playerCardStack.printCards();
	}
	
	public void receiveCard(Card card){
		playerCardStack.addCardAtTheBottom(card);
	}
	
	public void setPlayerCardStack(PlayerCardStack playerCardStack){
		this.playerCardStack = playerCardStack;
	}
	
	public Card giveCard(){
		return playerCardStack.removeCard();
	}

	public void moveTopCardDownwards() {
		Card card = playerCardStack.removeCard();
		playerCardStack.addCardAtTheBottom(card);
		
	}
	
	public void uncoverTopCard() {
		Card topCard =  playerCardStack.getTopCard();
		nameOfTopCard.setValue(topCard.getName());
		hpAttributeOfTopCard.setValue(topCard.getHp());
		kmhAttributeOfTopCard.setValue(topCard.getKmh());
		consumptionAttributeOfTopCard.setValue(topCard.getConsumption());  
		ccmAttributeOfTopCard.setValue(topCard.getCcm());
		accelerationAttributeOfTopCard.setValue(topCard.getAcceleration());
		jpgSourceOfTopCard.setValue(topCard.getSrcOfJpG());
		// obereKarteImg.setValue(topCard.getImageProperty().getValue());
		
	}
	
	
	public final StringProperty hpAttributeOfTopCardProperty () {
        return hpAttributeOfTopCard; 
	}
	
	public StringProperty kmhAttributeOfTopCardProperty() {
		return this.kmhAttributeOfTopCard;
	}
	
	public StringProperty consumptionAttributeOfTopCardProperty() {
		return this.consumptionAttributeOfTopCard;
	}
	
	public StringProperty ccmAttributeOfTopCardProperty() {
		return this.ccmAttributeOfTopCard;
	}
	
	public StringProperty accelerationAttributeOfTopCardProperty() {
		return this.accelerationAttributeOfTopCard;
	}
	
//	public ObjectProperty<javafx.scene.image.Image> obereKarteImgProperty () {
//		return this.obereKarteImg;
//	}

	
	public StringProperty nameOfTopCardProperty() {
		return this.nameOfTopCard;
	}

	public StringProperty jpgSourceOfTopCardProperty() {
		return this.jpgSourceOfTopCard;
	}
	
}
