package chat;

import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class ViewModel  {
	
	private Kartenstapel kartenstapel = new Kartenstapel();
	private int counter = 0;
	Spieler spieler1;
	Spielerstapel stapel1;
	
	boolean isServer = true;
//	boolean isServer = false;
	
	
	
	private NetworkConnection connection = isServer ? createServer() : createClient();
	
	@FXML
	private Text label0, label1, label2, label3, label4, label5;
	
	@FXML
	private ImageView imageDisplay;
	
	@FXML
	private AnchorPane setImage;
	
	@FXML
	private TextField textField = new TextField();
	
	@FXML
	private TextArea textArea = new TextArea();
	
	List<Karte> list = kartenstapel.getList();
	Karte karte = list.get(0);

	@FXML
    public void initialize() throws Exception {
		textArea.setEditable(false);
		connection.startConnection();
    }
	
	@FXML
	private void compare(ActionEvent event){
		Karte karte = list.get(0);
		imageDisplay.imageProperty().bind(karte.getImageProperty());
		label0.textProperty().bind(karte.nameProperty());
		label1.textProperty().bind(karte.psProperty());
		label2.textProperty().bind(karte.kmhProperty());
		label3.textProperty().bind(karte.verbrauchProperty());
		label4.textProperty().bind(karte.ccmProperty());
		label5.textProperty().bind(karte.beschleunigungProperty());
		kartenstapel.entferneErsteKarte();
		System.out.println("Stapelgröße: " + kartenstapel.getList().size());
		try {
			String message = "0" + karte.psProperty().getValue();
			connection.send(message);
		} catch (Exception e) {
			textArea.appendText("Failed to send\n");
		}
	}
	
	
	
	
	public void stop() throws Exception {
		connection.closeConnection();
	}
	
	@FXML
	private Server createServer() {
		return new Server(55555, data -> {
			Platform.runLater(() -> {
				if(data.toString().contains("PS")){
					
					System.out.println("Vergleiche label0 von Server mit label0 von Client");
				}
				else{
					textArea.appendText(data.toString()+ "\n");
				}
			});
		});
	}
	
	@FXML
	private Client createClient() {
		
		return new Client("localhost", 55555, data -> {
			Platform.runLater(() -> {
				textArea.appendText(data.toString()+ "\n");
			});
		});
	}
	
	
	@FXML
	private void senden(ActionEvent event){
		
		String message = isServer ? "Server: " : "Client: ";
		message += textField.getText();
		textField.clear();
		
		textArea.appendText(message + "\n");
		
		try {
			connection.send(message);
		} catch (Exception e) {
			textArea.appendText("Failed to send\n");
		}
		
		
	}
	
}

