package application;
	
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Main2 extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {

			
			
//			Scene scene = new Scene(root,400,400);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
//			Parent root = FXMLLoader.load(getClass().getResource("UI2.fxml"));
//			primaryStage.setScene(new Scene(root));
//			primaryStage.show();
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("UI2.fxml"));
	    	
	    	
	    	// Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
	        // View fooController = (View) FXMLLoader.getController();
	       
	    	// View controller = loader.<View>getController();
	    	Spiel spielmodel = new Spiel();
	    	spielmodel.starten();
	    	
			ViewModel2 viewModel = new ViewModel2();
	    	ViewSpieler1 view = new ViewSpieler1(viewModel); 
	    	
	    	loader.setController(view);
	    	Parent root = loader.load();
	    	primaryStage.setScene(new Scene(root));
	        primaryStage.show();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
		
	}
}





