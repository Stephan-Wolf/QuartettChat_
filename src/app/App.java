package app;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
	
	static boolean isserver = true;
	
	public static void main(final String[] args) throws IOException
    {	
		if(isserver == true){
	    	final IModel model = new Spiel ();
	        final Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
	        final IViewModel modelview = new ViewModel(model);
	        System.out.println(registry);
	        registry.rebind(IViewModel.IMODELVIEW, modelview);
	        launch(args);
		}
		else{
			
			launch(args);
		}
    }
	
	
	public void start(Stage primaryStage) throws Exception {
		if (isserver == true){
			 final Registry registry = LocateRegistry.getRegistry();
			 System.out.println(registry);   
			 final IViewModel viewmodel = (IViewModel) registry.lookup(IViewModel.IMODELVIEW);

		        View anwender = new View(viewmodel);
		        viewmodel.setBeobachter_1(anwender);
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
		  	
		    	loader.setController(anwender);
		    	Parent root = loader.load();
		    	primaryStage.setScene(new Scene(root));
		        primaryStage.show();
		}
		else{
			try {
				final Registry registry = LocateRegistry.getRegistry("localhost");
				final IViewModel viewmodel = (IViewModel) registry.lookup(IViewModel.IMODELVIEW);
				System.out.println(registry);
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
		
	}
	
	

}
