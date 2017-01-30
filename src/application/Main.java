package application;
	
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Main extends Application {

		Scene scene;
	    Stage thestage;
	    
	
	@Override
	public void start(Stage primaryStage) {
		thestage=primaryStage;
        
		try {
			Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
			scene = new Scene(root);
			thestage.setScene(scene);
			thestage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	 
	
	public static void main(String[] args) {
		Spiel spiel = new Spiel();
		spiel.starten();
		launch(args);
	}
	
}





