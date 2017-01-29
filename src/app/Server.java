package app;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Server extends Application
{
    public static void main(final String[] args) throws IOException
    {
    	final IModel model = new Spiel ();
        final Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        final IViewModel2 modelview = new ViewModel2(model);
        registry.rebind(IViewModel2.IMODELVIEW, modelview);
        launch(args);
    }
    

    public void start(Stage primaryStage) throws Exception
    {
        final Registry registry = LocateRegistry.getRegistry("localhost");
        final IViewModel2 viewmodel = (IViewModel2) registry.lookup(IViewModel2.IMODELVIEW);

        ViewSpieler anwender = new ViewSpieler(viewmodel);
        viewmodel.setBeobachter_1(anwender);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
  	
    	loader.setController(anwender);
    	Parent root = loader.load();
    	primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}