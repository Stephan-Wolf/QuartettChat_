package application.copy;

import java.io.File;
import java.lang.reflect.Array;
import java.util.List;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ViewSpieler1 {
	
	final String PS = "ps";
	final String KMH = "kmh";
	final String VERBRAUCH = "verbrauch";
	final String CCM = "ccm";
	final String BESCHLEUNIGUNG = "beschleunigung";
	
	private ViewModel2 viewmodel;
	
	@FXML
	private Text spieler1labelName, spieler1labelPS, spieler1labelKMH, spieler1labelVerbrauch, spieler1labelCCM, spieler1labelBeschleunigung;
	
	@FXML
	private Button spieler1ButtonPS, spieler1ButtonKMH, spieler1ButtonVerbrauch, spieler1ButtonCCM, spieler1ButtonBeschleunigung;
	
	@FXML
	private Text spieler2labelName, spieler2labelPS, spieler2labelKMH, spieler2labelVerbrauch, spieler2labelCCM, spieler2labelBeschleunigung;
	
	@FXML
	private Button spieler2ButtonPS, spieler2ButtonKMH, spieler2ButtonVerbrauch, spieler2ButtonCCM, spieler2ButtonBeschleunigung;
		
	@FXML
	private ImageView spieler1imageDisplay, spieler2imageDisplay;
	
	@FXML
	private AnchorPane setImage;
	
	@FXML
	private TextField textField = new TextField();
	
	@FXML
	private TextArea textArea = new TextArea();
	
	
	
	public ViewSpieler1(ViewModel2 viewmodel) {
		this.viewmodel = viewmodel;
		

	}
	
	@FXML
    public void initialize() {
		textArea.setEditable(false);
		spieler1labelName.textProperty().bind(viewmodel.getSpieler1NameProperty());
		spieler1labelPS.textProperty().bind(viewmodel.getSpieler1PsProperty());
		spieler1labelKMH.textProperty().bind(viewmodel.getSpieler1KmhProperty());
		spieler1labelVerbrauch.textProperty().bind(viewmodel.getSpieler1VerbrauchProperty());
		spieler1labelCCM.textProperty().bind(viewmodel.getSpieler1CcmProperty());
		spieler1labelBeschleunigung.textProperty().bind(viewmodel.getSpieler1BeschleunigungProperty());
		spieler1imageDisplay.imageProperty().bind(viewmodel.getSpieler1Img());
	
		// Buttons deaktivieren?
//		spieler1ButtonPS.disableProperty().bind(viewmodel.aktiverSpieler1Property());
//		spieler1ButtonKMH.disableProperty().bind(viewmodel.aktiverSpieler1Property());
//		spieler1ButtonVerbrauch.disableProperty().bind(viewmodel.aktiverSpieler1Property());
//		spieler1ButtonCCM.disableProperty().bind(viewmodel.aktiverSpieler1Property());
//		spieler1ButtonBeschleunigung.disableProperty().bind(viewmodel.aktiverSpieler1Property());

		
		// bind(viewmodel.getSpieler1Img());
		spieler2labelName.textProperty().bind(viewmodel.getSpieler2NameProperty());
		spieler2labelPS.textProperty().bind(viewmodel.getSpieler2PsProperty());
		spieler2labelKMH.textProperty().bind(viewmodel.getSpieler2KmhProperty());
		spieler2labelVerbrauch.textProperty().bind(viewmodel.getSpieler2VerbrauchProperty());
		spieler2labelCCM.textProperty().bind(viewmodel.getSpieler2CcmProperty());
		spieler2labelBeschleunigung.textProperty().bind(viewmodel.getSpieler2BeschleunigungProperty());
		spieler2imageDisplay.imageProperty().bind(viewmodel.getSpieler2Img());
//		
		// Buttons deaktivieren?
//		spieler2ButtonPS.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
//		spieler2ButtonKMH.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
//		spieler2ButtonVerbrauch.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
//		spieler2ButtonCCM.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
//		spieler2ButtonBeschleunigung.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
		
		
    }
	
	@FXML
	private void spieler1comparePS(ActionEvent event){
		viewmodel.change(PS);
	}
	
	
	@FXML
	private void spieler1compareKMH(ActionEvent event){
		viewmodel.change(KMH);
	}
	
	@FXML
	private void spieler1compareVerbrauch(ActionEvent event){
		viewmodel.change(VERBRAUCH);
	}
	
	@FXML
	private void spieler1compareCCM(ActionEvent event){
		viewmodel.change(CCM);
	}
	
	@FXML
	private void spieler1compareBeschleunigung(ActionEvent event){
		viewmodel.change(BESCHLEUNIGUNG);
	}
	
	@FXML
	private void spieler2comparePS(ActionEvent event){
		viewmodel.change(PS);
	}
	
	@FXML
	private void spieler2compareKMH(ActionEvent event){
		viewmodel.change(KMH);
	}
	
	@FXML
	private void spieler2compareVerbrauch(ActionEvent event){
		viewmodel.change(VERBRAUCH);
	}
	
	@FXML
	private void spieler2compareCCM(ActionEvent event){
		viewmodel.change(CCM);
	}
	
	@FXML
	private void spieler2compareBeschleunigung(ActionEvent event){
		viewmodel.change(BESCHLEUNIGUNG);
	}
	
	@FXML
	private void compare(ActionEvent event){

	}
	
	
	
	@FXML
	private void senden(ActionEvent event){
		textArea.appendText(textField.getText());
		textField.clear();
	}

}

