/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartController  {

	@FXML
    Button serverStart;
    @FXML
    Button clientStart;
    @FXML
    Button info;
    
    
    
    
    //Eventuell noch eine Abfrage einbauen welche prüft ob Server oder CLient um dann die Buttons in der initialize() zu disablen
    @FXML
    private void serverStart(ActionEvent event) throws IOException{
    	final IModel model = new Spiel ();
        final Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        final IViewModel modelview = new ViewModel(model);
        System.out.println(registry);
        registry.rebind(IViewModel.IMODELVIEW, modelview);	
    	
        
		 System.out.println(registry);   
		 IViewModel viewmodel;
		try {
			viewmodel = (IViewModel) registry.lookup(IViewModel.IMODELVIEW);
			View anwender = new View(viewmodel,1);
			viewmodel.setBeobachter_1(anwender);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
			loader.setController(anwender);
			Parent root = loader.load();
			Scene UI_scene = new Scene(root); 
			Stage UI_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			UI_stage.setScene(UI_scene);
			UI_stage.show();
			UI_stage.setOnCloseRequest(e -> {
				Platform.exit();
				System.exit(0);
			});
			System.out.println("Server läuft!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
	private void clientStart(ActionEvent event) throws IOException{
		try {
			final Registry registry = LocateRegistry.getRegistry("localhost");
			final IViewModel viewmodel = (IViewModel) registry.lookup(IViewModel.IMODELVIEW);
			System.out.println(registry);
			View anwender = new View(viewmodel,2);
			viewmodel.setBeobachter_2(anwender);
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
			loader.setController(anwender);
			Parent root = loader.load();
			Scene UI_scene = new Scene(root); 
			Stage UI_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			UI_stage.setScene(UI_scene);
			UI_stage.show();
			UI_stage.setOnCloseRequest(e -> {
				Platform.exit();
				System.exit(0);
			});
			System.out.println("Client verbunden!");
		} catch(Exception e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    private void info(ActionEvent event) throws IOException{
    	Parent info_parent = FXMLLoader.load(getClass().getResource("Info.fxml"));
    	Scene info_scene = new Scene(info_parent); 
		Stage info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		info_stage.setScene(info_scene);
		info_stage.show();
    }
    
    

}
