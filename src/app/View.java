package app;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
	
	private IViewModel viewmodel;
	
	@FXML
	private Text labelName, labelPS, labelKMH, labelVerbrauch, labelCCM, labelBeschleunigung, labelKartenanzahl;
	
	@FXML
	private Button buttonPS, buttonKMH, buttonVerbrauch, buttonCCM, buttonBeschleunigung;
	
	@FXML
	private ImageView imageDisplay;
	
	
	@FXML
	private TextField textField = new TextField();
	
	@FXML
	private TextArea textArea = new TextArea();
	
	
	
	public View (IViewModel viewmodel) throws RemoteException{
		this.viewmodel = viewmodel;
	}
	
	@FXML
    public void initialize() {
		textArea.setEditable(false);
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
	private void startGame (ActionEvent event) throws RemoteException{
	}
	
	
	@FXML
	private void senden(ActionEvent event){
		textArea.appendText(textField.getText());
		textField.clear();
	}

	@Override
	public void update(String name, String ps, String kmh, String verbrauch, String ccm, String beschleunigung,
			boolean aktiverSpieler, String kartenanzahl, String jpgUrl) throws RemoteException {
		
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
			}
		};
		/// ????
		thread.setDaemon(true);
		thread.start();
		
	}

}

