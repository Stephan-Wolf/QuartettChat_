package application;

import java.io.File;
import java.lang.reflect.Array;

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
	
	@FXML
	private Text label1, label2, label3, label4, label5;
	
	@FXML
	private ImageView imageDisplay;
	
	@FXML
	private AnchorPane setImage;
	
	
	
	
//	Image image = new Image("file:///Users/christianhechtberger/git/QuartettChat_/src/application/Img/BMWZ1.jpg");
	Image image2 = new Image("file:///Users/christianhechtberger/git/QuartettChat_/src/application/Img/Audi-V8.jpg");
	
	Karte karte = new Karte("Audi-V8","/Img/Audi-V8.jpg", "500", "250","16.5","6500","4");
	
	
	@FXML
	private void compare(ActionEvent event){
		Karte karte = new Karte("BMW Z1","/Img/BMWZ1.jpg", "300", "150","12.5","6200","2");
		switchCards();
	}
	
	@FXML
	private void nextCard(ActionEvent event){
		Karte karte = new Karte("Audi-V8","/Img/Audi-V8.jpg", "500", "250","16.5","6500","4");
		switchCards();
//		Image image = new Image(karte.getImage());
		System.out.println(karte.getImageProperty());
//		imageDisplay.setImage(image);	
		
	}

	@FXML
	private void switchCards(){
		imageDisplay.imageProperty().bind(karte.getImageProperty());
		label1.textProperty().bind(karte.psProperty());
		label2.textProperty().bind(karte.kmhProperty());
		label3.textProperty().bind(karte.verbrauchProperty());
		label4.textProperty().bind(karte.ccmProperty());
		label5.textProperty().bind(karte.beschleunigungProperty());
	}
	

}

