package app;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Optional;

public class View  extends UnicastRemoteObject implements Observer {
	
	private Thread thread;
	final String HP = "ps";
	final String KMH = "kmh";
	final String CONSUMPTION = "verbrauch";
	final String CCM = "ccm";
	final String ACCELERATION = "beschleunigung";
	private static final long serialVersionUID = 1L;
	private int id;
	private IViewModel viewmodel;
	@FXML
	private GridPane hideOnEnd;
	@FXML
	private Pane showOnEnd, hideOnEnd2;
	@FXML
	private Text labelName, labelHP, labelKMH, labelConsumption, labelCCM, labelAcceleration, labelKartenanzahl, labelRundenstatus;
	@FXML
	private Button buttonHP, buttonKMH, buttonConsumption, buttonCCM, buttonAcceleration, restartButton, endGameButton, buttonSend;
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
		textArea.setWrapText(true);
		showOnEnd.setVisible(false);
    }
	
	@Override
	public int getID() throws RemoteException{
		return id;
	}
	
	@FXML
	private void compareHP(ActionEvent event) throws RemoteException{
		viewmodel.change(HP);
	}
	
	@FXML
	private void compareKMH(ActionEvent event) throws RemoteException{
		viewmodel.change(KMH);
	}
	
	@FXML
	private void compareConsumption(ActionEvent event) throws RemoteException{
		viewmodel.change(CONSUMPTION);
	}
	
	@FXML
	private void compareCCM(ActionEvent event) throws RemoteException{
		viewmodel.change(CCM);
	}
	
	@FXML
	private void compareAcceleration(ActionEvent event) throws RemoteException{
		viewmodel.change(ACCELERATION);
	}
	
	@FXML
	private void restartGame (ActionEvent event) throws RemoteException{
		viewmodel.restartGame(this.getID());
		restartButton.setDisable(true);
		endGameButton.setDisable(true);
	}
	
	@FXML
	private void endGame (ActionEvent event) throws Exception{
		viewmodel.quitGame(this.getID());
		showAlert();
	}
	
	@FXML
	private void send(ActionEvent event) throws RemoteException{
		String message = textField.getText();
		textArea.appendText("Spieler: "+ message  + "\n");		
		textField.clear();
		viewmodel.changeChat(message, getID());
	}
	
	@FXML
	private void enter(ActionEvent event) throws RemoteException{
		this.send(event);
	}
	
	@Override
	public void update(String name, String hp, String kmh, String consumption, String ccm, String acceleration,
			boolean isPlayerActive, int numberOfCards, String jpgUrl, String status) throws RemoteException {

		if (numberOfCards == 0 || numberOfCards == 16){
			hideOnEnd.setVisible(false);
			hideOnEnd2.setVisible(false);
			showOnEnd.setVisible(true);
			
			if(numberOfCards == 0){
				labelName.setText("CRASH Du hast verloren");
				String image = new String("/Img/car_crash.jpg");
		        Image imageUse = new Image(image);
		        imageDisplay.setImage(imageUse);
			}
			if(numberOfCards == 16){
				labelName.setText("WINNER Du hast gewonnen");
				String image = new String("/Img/Zielflagge.jpg");
		        Image imageUse = new Image(image);
		        imageDisplay.setImage(imageUse);
			}
			
		}
		else {
			
	        String image = new String(jpgUrl);
	        Image imageUse = new Image(image);
	        
			
			thread = new Thread () {
				public void run() {		
					Platform.runLater(() -> labelName.setText(name));
					Platform.runLater(() -> labelHP.setText(hp));
					Platform.runLater(() -> labelKMH.setText(kmh));
					Platform.runLater(() -> labelConsumption.setText(consumption));
					Platform.runLater(() -> labelCCM.setText(ccm));
					Platform.runLater(() -> labelAcceleration.setText(acceleration));
					Platform.runLater(() -> buttonHP.setDisable(!isPlayerActive));
					Platform.runLater(() -> buttonKMH.setDisable(!isPlayerActive));
					Platform.runLater(() -> buttonConsumption.setDisable(!isPlayerActive));
					Platform.runLater(() -> buttonCCM.setDisable(!isPlayerActive));
					Platform.runLater(() -> buttonAcceleration.setDisable(!isPlayerActive));
					Platform.runLater(() -> labelKartenanzahl.setText(String.valueOf(numberOfCards)));
					Platform.runLater(() -> imageDisplay.setImage(imageUse));
					Platform.runLater(() -> labelRundenstatus.setText(status));
				}
			};
			thread.start();
		}
	}
	
	@Override
	public void updateChat(String message) throws RemoteException{
		thread = new Thread () {
			public void run() {		
				Platform.runLater(() -> textArea.appendText(message  + "\n"));
			}
		};
		thread.start();
	}

	@Override
	public void updateRestartGame() throws RemoteException {
		thread = new Thread () {
			public void run() {		
				Platform.runLater(() -> hideOnEnd.setVisible(true));
				Platform.runLater(() -> showOnEnd.setVisible(false));
				Platform.runLater(() -> restartButton.setDisable(false));
				Platform.runLater(() -> endGameButton.setDisable(false));
				Platform.runLater(() -> hideOnEnd2.setVisible(true));
				Platform.runLater(() -> labelRundenstatus.setText("Jetzt gehts los"));
			}
		};
		thread.start();
	}
	
	@Override
	public void updateQuitGame() throws RemoteException {
		thread = new Thread () {
			public void run() {
				Platform.runLater(() -> showAlert());
			}
		};
		thread.start();
	}
	
	@FXML
	public void showAlert() {
		try {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Verbindung");
			alert.setHeaderText("Spiel wurde beendet!");
			ButtonType close = new ButtonType("OK");
			alert.getButtonTypes().setAll(close);
			Optional<ButtonType> result = alert.showAndWait();
			
			if(result.get() == close){
				Platform.exit();
				System.exit(0);
				
			}
			else{
				alert.hide();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Platform.exit();
			System.exit(0);
		}
		
	}

	@Override
	public void updateButtonSend() throws RemoteException {
		thread = new Thread () {
			public void run() {		
				Platform.runLater(() -> buttonSend.setDisable(false));
			}
		};
		thread.start();
	}
		
}	


