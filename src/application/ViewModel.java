package application;

import java.io.File;
import java.lang.reflect.Array;
import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ViewModel {
	
	private Kartenstapel kartenstapel = new Kartenstapel();
	private int counter = 0;
	@FXML
	private Text label0, label1, label2, label3, label4, label5;
	
	@FXML
	private ImageView imageDisplay;
	
	@FXML
	private AnchorPane setImage;
	
	
	List<Karte> list = kartenstapel.getList();
	Karte karte = list.get(0);
	
	@FXML
	private void compare(ActionEvent event){
		kartenstapel.entferneErsteKarte();
		Karte karte = list.get(0);
		imageDisplay.imageProperty().bind(karte.getImageProperty());
		label0.textProperty().bind(karte.nameProperty());
		label1.textProperty().bind(karte.psProperty());
		label2.textProperty().bind(karte.kmhProperty());
		label3.textProperty().bind(karte.verbrauchProperty());
		label4.textProperty().bind(karte.ccmProperty());
		label5.textProperty().bind(karte.beschleunigungProperty());
		System.out.println("Stapelgröße: " + kartenstapel.getList().size());
	}
	
	@FXML
	private void nextCard(ActionEvent event){
		Karte karte = list.get(counter);
		imageDisplay.imageProperty().bind(karte.getImageProperty());
		label1.textProperty().bind(karte.psProperty());
		label2.textProperty().bind(karte.kmhProperty());
		label3.textProperty().bind(karte.verbrauchProperty());
		label4.textProperty().bind(karte.ccmProperty());
		label5.textProperty().bind(karte.beschleunigungProperty());
		counter++;
	}

}

