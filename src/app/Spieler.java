package app;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class Spieler {
	
	private StringProperty nameOfTopCard = new SimpleStringProperty();
	private StringProperty hpAttributeOfTopCard = new SimpleStringProperty();
	private StringProperty kmhAttributeOfTopCard =  new SimpleStringProperty();
	private StringProperty consumptionAttributeOfTopCard =  new SimpleStringProperty();
	private StringProperty ccmAttributeOfTopCard =  new SimpleStringProperty();	
	private StringProperty accelerationAttributeOfTopCard =  new SimpleStringProperty();
	private StringProperty jpgSourceOfTopCard =  new SimpleStringProperty();
	private ObjectProperty<javafx.scene.image.Image> obereKarteImg = new SimpleObjectProperty<>();
	
	//jgpUrlProperty
	// public?? brauchen wir die Variable?
	// public Karte obereKarte;
	private PlayerCardStack playerCardStack = new PlayerCardStack();
//	private int spielerId;
//	private boolean hatKarte;
//	private boolean connencted;
	
	
	public Spieler () {
	}
	
	// TEstMEthode
	public void printAllCards() {
		playerCardStack.zeigeKarten();
	}
	
	public void receiveCard(Karte card){
		playerCardStack.fuegeKarteUntenHinzu(card);
	}
	
	public void setPlayerCardStack(PlayerCardStack playerCardStack){
		this.playerCardStack = playerCardStack;
	}
	
	public Karte giveCard(){
		return playerCardStack.entferneKarte();
	}

	public void moveTopCardDownwards() {
		Karte card = playerCardStack.entferneKarte();
		playerCardStack.fuegeKarteUntenHinzu(card);
		
	}
	
	public void uncoverTopCard() {
		Karte topCard =  playerCardStack.gebeObereKarte();
		nameOfTopCard.setValue(topCard.getNameProperty().getValue());
		hpAttributeOfTopCard.setValue(topCard.getPsProperty().getValue());
		kmhAttributeOfTopCard.setValue(topCard.getKmhProperty().getValue());
		consumptionAttributeOfTopCard.setValue(topCard.getVerbrauchProperty().getValue());  
		ccmAttributeOfTopCard.setValue(topCard.getCcmProperty().getValue());
		accelerationAttributeOfTopCard.setValue(topCard.getBeschleunigungProperty().getValue());
		jpgSourceOfTopCard.setValue(topCard.getJgpUrlProperty().getValue());
		obereKarteImg.setValue(topCard.getImageProperty().getValue());
		
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
