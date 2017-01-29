package app;

import java.io.File;
import java.lang.reflect.Array;
import java.util.List;

import javafx.application.Platform;
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


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ViewSpieler  extends UnicastRemoteObject implements Beobachter {
	
	private Thread thread;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final String PS = "ps";
	final String KMH = "kmh";
	final String VERBRAUCH = "verbrauch";
	final String CCM = "ccm";
	final String BESCHLEUNIGUNG = "beschleunigung";
	
	private IViewModel2 viewmodel;
	
	@FXML
	private Text labelName, labelPS, labelKMH, labelVerbrauch, labelCCM, labelBeschleunigung;
	
	@FXML
	private Button buttonPS, buttonKMH, buttonVerbrauch, buttonCCM, buttonBeschleunigung;
	
//	@FXML
//	private Text spieler2labelName, spieler2labelPS, spieler2labelKMH, spieler2labelVerbrauch, spieler2labelCCM, spieler2labelBeschleunigung;
//	
//	@FXML
//	private Button spieler2ButtonPS, spieler2ButtonKMH, spieler2ButtonVerbrauch, spieler2ButtonCCM, spieler2ButtonBeschleunigung;
//		
//	@FXML
//	private ImageView spieler1imageDisplay, spieler2imageDisplay;
//	
//	@FXML
//	private AnchorPane setImage;
	
	@FXML
	private TextField textField = new TextField();
	
	@FXML
	private TextArea textArea = new TextArea();
	
	
	
	public ViewSpieler (IViewModel2 viewmodel) throws RemoteException{
		this.viewmodel = viewmodel;
	}
	
	@FXML
    public void initialize() {
		textArea.setEditable(false);
		
//		spieler1labelName.textProperty().bind(viewmodel.getSpieler1NameProperty());
//		spieler1labelPS.textProperty().bind(viewmodel.getSpieler1PsProperty());
//		spieler1labelKMH.textProperty().bind(viewmodel.getSpieler1KmhProperty());
//		spieler1labelVerbrauch.textProperty().bind(viewmodel.getSpieler1VerbrauchProperty());
//		spieler1labelCCM.textProperty().bind(viewmodel.getSpieler1CcmProperty());
//		spieler1labelBeschleunigung.textProperty().bind(viewmodel.getSpieler1BeschleunigungProperty());
//		spieler1imageDisplay.imageProperty().bind(viewmodel.getSpieler1Img());
	
		// Buttons deaktivieren?
//		spieler1ButtonPS.disableProperty().bind(viewmodel.aktiverSpieler1Property());
//		spieler1ButtonKMH.disableProperty().bind(viewmodel.aktiverSpieler1Property());
//		spieler1ButtonVerbrauch.disableProperty().bind(viewmodel.aktiverSpieler1Property());
//		spieler1ButtonCCM.disableProperty().bind(viewmodel.aktiverSpieler1Property());
//		spieler1ButtonBeschleunigung.disableProperty().bind(viewmodel.aktiverSpieler1Property());

		
		// bind(viewmodel.getSpieler1Img());
//		spieler2labelName.textProperty().bind(viewmodel.getSpieler2NameProperty());
//		spieler2labelPS.textProperty().bind(viewmodel.getSpieler2PsProperty());
//		spieler2labelKMH.textProperty().bind(viewmodel.getSpieler2KmhProperty());
//		spieler2labelVerbrauch.textProperty().bind(viewmodel.getSpieler2VerbrauchProperty());
//		spieler2labelCCM.textProperty().bind(viewmodel.getSpieler2CcmProperty());
//		spieler2labelBeschleunigung.textProperty().bind(viewmodel.getSpieler2BeschleunigungProperty());
//		spieler2imageDisplay.imageProperty().bind(viewmodel.getSpieler2Img());
//		
		// Buttons deaktivieren?
//		spieler2ButtonPS.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
//		spieler2ButtonKMH.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
//		spieler2ButtonVerbrauch.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
//		spieler2ButtonCCM.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
//		spieler2ButtonBeschleunigung.disableProperty().bind(viewmodel.aktiverSpieler1Property().not());
		
		
    }
	
	@FXML
	private void comparePS(ActionEvent event) throws RemoteException{
		viewmodel.change(PS);
		System.out.println("View: comparePS");
	}
	
	
	@FXML
	private void compareKMH(ActionEvent event) throws RemoteException{
		viewmodel.change(KMH);
	}
	
	@FXML
	private void compareVerbrauch(ActionEvent event) throws RemoteException{
		viewmodel.change(VERBRAUCH);
	}
	
	@FXML
	private void compareCCM(ActionEvent event) throws RemoteException{
		viewmodel.change(CCM);
	}
	
	@FXML
	private void compareBeschleunigung(ActionEvent event) throws RemoteException{
		viewmodel.change(BESCHLEUNIGUNG);
	}
	
//	@FXML
//	private void spieler2comparePS(ActionEvent event) throws RemoteException{
//		viewmodel.change(PS);
//	}
//	
//	@FXML
//	private void spieler2compareKMH(ActionEvent event) throws RemoteException{
//		viewmodel.change(KMH);
//	}
//	
//	@FXML
//	private void spieler2compareVerbrauch(ActionEvent event) throws RemoteException{
//		viewmodel.change(VERBRAUCH);
//	}
//	
//	@FXML
//	private void spieler2compareCCM(ActionEvent event) throws RemoteException{
//		viewmodel.change(CCM);
//	}
//	
//	@FXML
//	private void spieler2compareBeschleunigung(ActionEvent event) throws RemoteException{
//		viewmodel.change(BESCHLEUNIGUNG);
//	}
//	
//	@FXML
//	private void compare(ActionEvent event){
//
//	}
	
	
	
	@FXML
	private void senden(ActionEvent event){
		textArea.appendText(textField.getText());
		textField.clear();
	}

	@Override
	public void update(String name, String ps, String kmh, String verbrauch, String ccm, String beschleunigung,
			boolean aktiverSpieler) throws RemoteException {
		
		System.out.println("ViewSpieler update");
		System.out.println("Name: " + name);
		System.out.println("PS: " + ps );
		System.out.println("KMH: " + kmh);
		System.out.println("VERBRAUCH: " + verbrauch);
		System.out.println("CCM: " + ccm);
		System.out.println("Beschleunigung:" + beschleunigung);
		
		thread = new Thread () {
			public void run() {		
				Platform.runLater(() -> labelName.setText(name));
				Platform.runLater(() -> labelPS.setText(ps));
				Platform.runLater(() -> labelKMH.setText(kmh));
				Platform.runLater(() -> labelVerbrauch.setText(verbrauch));
				Platform.runLater(() -> labelCCM.setText(ccm));
				Platform.runLater(() -> labelBeschleunigung.setText(beschleunigung));
				Platform.runLater(() -> buttonPS.setDisable(!aktiverSpieler));
				Platform.runLater(() -> buttonKMH.setDisable(!aktiverSpieler));
				Platform.runLater(() -> buttonVerbrauch.setDisable(!aktiverSpieler));
				Platform.runLater(() -> buttonCCM.setDisable(!aktiverSpieler));
				Platform.runLater(() -> buttonBeschleunigung.setDisable(!aktiverSpieler));
				
			}
		};
		/// ????
		thread.setDaemon(true);
		thread.start();
		
	}

}

