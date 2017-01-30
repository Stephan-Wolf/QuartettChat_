package chat;
	
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
	
	    Button btnServer, btnClient;
	    Label lblscene1, lblscene2;
	    Scene scene0, scene1, scene2;
	    Stage thestage;
	    VBox box1;
//	    boolean isServer = true;
	    
	
	@Override
	public void start(Stage primaryStage) {
		thestage=primaryStage;
//		 	btnServer=new Button("Spieler 1");
//	        btnClient=new Button("Spieler 2");
//	        btnServer.setOnAction(e-> ButtonClicked(e));
//	        btnClient.setOnAction(e-> ButtonClicked(e));
        
		try {
//			Spiel spiel = new Spiel();
//			spiel.starten();
			Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
//			Parent root2 = FXMLLoader.load(getClass().getResource("UIStart.fxml"));
//			scene0 = new Scene(root2);
			scene1 = new Scene(root);
			VBox box = new VBox();
//			box.getChildren().addAll(root2, btnServer, btnClient);
//			scene0 = new Scene(box);
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			thestage.setScene(scene1);
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
	
	
	
//	
//	public void ButtonClicked(ActionEvent e)
//    {
//        if (e.getSource().toString().contains("Spieler 1")){
//            isServer = true;
//            System.out.println("TEST1 " + isServer);
//        	thestage.setScene(scene1);
//        }    
//        else if(e.getSource().toString().contains("Spieler 2")){
//        	isServer = false;
//        	System.out.println("TEST2 " + isServer);
//        	thestage.setScene(scene1);
//        }
//    }

	
}





