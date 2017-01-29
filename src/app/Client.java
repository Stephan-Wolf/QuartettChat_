package app;
	
import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {

	        final Registry registry = LocateRegistry.getRegistry("localhost");
	        final IViewModel viewmodel = (IViewModel) registry.lookup(IViewModel.IMODELVIEW);

	        View anwender = new View(viewmodel);
	        viewmodel.setBeobachter_2(anwender);

			FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
	    	loader.setController(anwender);
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