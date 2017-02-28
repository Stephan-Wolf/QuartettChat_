package app;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.stage.WindowEvent;

import java.awt.Frame;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.EventObject;
import java.util.Optional;

public class View  extends UnicastRemoteObject implements Beobachter {
	
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
	
	private int id;
	
	private IViewModel viewmodel;
	
	@FXML
	private GridPane hideOnEnd;
	
	@FXML
	private Pane showOnEnd, hideOnEnd2;
	
	@FXML
	private Text labelName, labelPS, labelKMH, labelVerbrauch, labelCCM, labelBeschleunigung, labelKartenanzahl, labelRundenstatus;
	
	@FXML
	private Button buttonPS, buttonKMH, buttonVerbrauch, buttonCCM, buttonBeschleunigung, restartButton, endGameButton;
	
	@FXML
	private ImageView imageDisplay;
	
	
	@FXML
	private TextField textField = new TextField();
	
	@FXML
	private TextArea textArea = new TextArea();

	public View (IViewModel viewmodel, int id) throws RemoteException{
		this.viewmodel = viewmodel;
		this.id = id;
	}
	
	@FXML
    public void initialize() {
		textArea.setEditable(false);
		showOnEnd.setVisible(false);
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
	
	@FXML
	private void restartGame (ActionEvent event) throws RemoteException{
		viewmodel.spielWiederholen(this.getID());
		restartButton.setDisable(true);
		endGameButton.setDisable(true);
		// jetzt in der methode updateSpielwiederoholung ()
		// hideOnEnd.setVisible(true);
		// showOnEnd.setVisible(false);
	}
	
	@FXML
	private void endGame (ActionEvent event) throws Exception{
		showAlert();
		viewmodel.spielBeenden(getID());
		System.out.println("endGame");
	}
	
	@FXML
	private void windowClosing(WindowEvent e) throws RemoteException{
		showAlert();
		viewmodel.spielBeenden(getID());
		System.out.println("windowClosing");
	}
	
	@FXML
	private void senden(ActionEvent event) throws RemoteException{
		String message = textField.getText();
		textArea.appendText("Spieler: "+ message  + "\n");		
		textField.clear();
		viewmodel.changeChat(message, getID());
	}
	
	@FXML
	private void enter(ActionEvent event) throws RemoteException{
		this.senden(event);
	}
	
	@Override
	public void update(String name, String ps, String kmh, String verbrauch, String ccm, String beschleunigung,
			boolean aktiverSpieler, String kartenanzahl, String jpgUrl, String status) throws RemoteException {
			int i = Integer.parseInt(kartenanzahl);
		if (i == 0 || i == 16){
			hideOnEnd.setVisible(false);
			hideOnEnd2.setVisible(false);
			showOnEnd.setVisible(true);
			
			if(i == 0){
				System.out.println("if i == 0" + i);
				labelName.setText("CRASH Du hast verloren");
				String image = new String("/Img/car_crash.jpg");
		        Image imageUse = new Image(image);
		        imageDisplay.setImage(imageUse);
			}
			if(i == 16){
				System.out.println("if i == 16" + i);
				labelName.setText("WINNER Du hast gewonnen");
				String image = new String("/Img/Zielflagge.jpg");
		        Image imageUse = new Image(image);
		        imageDisplay.setImage(imageUse);
			}
			
		}
		else {
		
			System.out.println("ViewSpieler update");
			System.out.println("Name: " + name);
			System.out.println("PS: " + ps );
			System.out.println("KMH: " + kmh);
			System.out.println("VERBRAUCH: " + verbrauch);
			System.out.println("CCM: " + ccm);
			System.out.println("Beschleunigung: " + beschleunigung);
			System.out.println("Kartenanzahl: " + kartenanzahl);
			System.out.println("jpgUrl: " + jpgUrl);
	
			
	        String image = new String(jpgUrl);
	        Image imageUse = new Image(image);
	        
			
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
					Platform.runLater(() -> labelKartenanzahl.setText(kartenanzahl));
					Platform.runLater(() -> imageDisplay.setImage(imageUse));
					Platform.runLater(() -> labelRundenstatus.setText(status));
				}
			};
			/// ????
			thread.setDaemon(true);
			thread.start();
		}
	}

	@Override
	public int getID() throws RemoteException{
		return id;
	}

	@Override
	public void updateChat(String message) throws RemoteException{
		// oder lieber ein zweites Attribut definieren?? 
		System.out.println("updateChat()");
		thread = new Thread () {
			public void run() {		
				Platform.runLater(() -> textArea.appendText(message  + "\n"));

				System.out.println("updateChat() run()");
			}
		};
		thread.start();
	}

	@Override
	public void updateSpielwiederholung() throws RemoteException {
		thread = new Thread () {
			public void run() {		
				Platform.runLater(() -> hideOnEnd.setVisible(true));
				Platform.runLater(() -> showOnEnd.setVisible(false));
				Platform.runLater(() -> restartButton.setDisable(false));
				Platform.runLater(() -> endGameButton.setDisable(false));
				Platform.runLater(() -> hideOnEnd2.setVisible(true));
				Platform.runLater(() -> labelRundenstatus.setText("Jetzt gehts los"));
//				showOnEnd.setVisible(false);
//				restartButton.setDisable(false);
//				endGameButton.setDisable(false);			
				System.out.println("updateSpielwiederholung() run()");
			}
		};
		thread.start();
	}
	@Override
	public void updateSpielBeenden() throws RemoteException {
		thread = new Thread () {
			public void run() {
				Platform.runLater(() -> showAlert());
			}
		};
		thread.start();
	}
	
	@FXML
	public void showAlert() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Verbindung");
		alert.setHeaderText("Wollen sie das Spiel wirklich beenden?");
		
		ButtonType beenden = new ButtonType("Ja");
		ButtonType nichtBeenden = new ButtonType("Nein");
		
		alert.getButtonTypes().setAll(beenden, nichtBeenden);
		
		Optional<ButtonType> result = alert.showAndWait();
		if(result.get() == beenden){
				System.out.println("Beenden Button Macht auch was");
				System.out.println("Beenden Button Macht auch was");
			    Window stage = alert.getOwner().getScene().getWindow();
			    System.out.println(stage);
//			    stage.setOnCloseRequest(e -> {
//					Platform.exit();
//					System.exit(0);
//				});
		}
		else{
			alert.hide();
		}
	}
		
		
}	


