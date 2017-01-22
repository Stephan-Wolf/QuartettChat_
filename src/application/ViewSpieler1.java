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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ViewSpieler1 {
	
	private ViewModel2 viewmodel;
	
	@FXML
	private Text spieler1labelPS, spieler1labelKMH, spieler1labelVerbrauch, spieler1labelCCM, spieler1labelBeschleunigung;
	
	@FXML
	private Text spieler2labelPS, spieler2labelKMH, spieler2labelVerbrauch, spieler2labelCCM, spieler2labelBeschleunigung;
		
	@FXML
	private ImageView imageDisplay;
	
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
		spieler1labelPS.textProperty().bind(viewmodel.getSpieler1PsProperty());
		spieler1labelKMH.textProperty().bind(viewmodel.getSpieler1KmhProperty());
		spieler1labelVerbrauch.textProperty().bind(viewmodel.getSpieler1VerbrauchProperty());
		spieler1labelCCM.textProperty().bind(viewmodel.getSpieler1CcmProperty());
		spieler1labelBeschleunigung.textProperty().bind(viewmodel.getSpieler1BeschleunigungProperty());
		// bind(viewmodel.getSpieler1Img());
		
		spieler2labelPS.textProperty().bind(viewmodel.getSpieler2PsProperty());
		spieler2labelKMH.textProperty().bind(viewmodel.getSpieler2KmhProperty());
		spieler2labelVerbrauch.textProperty().bind(viewmodel.getSpieler2VerbrauchProperty());
		spieler2labelCCM.textProperty().bind(viewmodel.getSpieler2CcmProperty());
		spieler2labelBeschleunigung.textProperty().bind(viewmodel.getSpieler2BeschleunigungProperty());
    }
	
	@FXML
	private void spieler1comparePS(ActionEvent event){
	}
	
	@FXML
	private void spieler1compareKMH(ActionEvent event){
	}
	
	@FXML
	private void spieler1compareVerbrauch(ActionEvent event){
	}
	
	@FXML
	private void spieler1compareCCM(ActionEvent event){
	}
	
	@FXML
	private void spieler1compareBeschleunigung(ActionEvent event){
	}
	
	@FXML
	private void spieler2comparePS(ActionEvent event){
	}
	
	@FXML
	private void spieler2compareKMH(ActionEvent event){
	}
	
	@FXML
	private void spieler2compareVerbrauch(ActionEvent event){
	}
	
	@FXML
	private void spieler2compareCCM(ActionEvent event){
	}
	
	@FXML
	private void spieler2compareBeschleunigung(ActionEvent event){
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

