package app;

import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartController  {
	
	
    @FXML
	private void start(ActionEvent event) throws IOException{
		try {
			final Registry registry = LocateRegistry.getRegistry("localhost");
			final IViewModel viewmodel = (IViewModel) registry.lookup(IViewModel.IMODELVIEW);
			View user = new View(viewmodel,2);
			viewmodel.setObserver2(user);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
			loader.setController(user);
			Parent root = loader.load();
			Scene UI_scene = new Scene(root); 
			Stage UI_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			UI_stage.setScene(UI_scene);
			UI_stage.show();
			UI_stage.setOnCloseRequest(e -> {
				try {
					viewmodel.quitGame(user.getID());
					showAlert(e);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			});
		} catch(Exception e) {
			final IGame model = new Game ();
	        final Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
	        final IViewModel modelview = new ViewModel(model);
	        registry.rebind(IViewModel.IMODELVIEW, modelview);	
			IViewModel viewmodel;
			try {
				viewmodel = (IViewModel) registry.lookup(IViewModel.IMODELVIEW);
				View user = new View(viewmodel,1);
				viewmodel.setObserver1(user);
				FXMLLoader loader = new FXMLLoader(getClass().getResource("UI.fxml"));
				loader.setController(user);
				Parent root = loader.load();
				Scene UI_scene = new Scene(root); 
				Stage UI_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				UI_stage.setScene(UI_scene);
				UI_stage.show();
				UI_stage.setOnCloseRequest(e2 -> {
					
					try {
						viewmodel.quitGame(user.getID());
						showAlert(e2);
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				});
			} catch (Exception e2) {
				e.printStackTrace();
			}
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
    
	public void showAlert(WindowEvent e) {
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
					e.consume();
			}
			else{
				e.consume();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			Platform.exit();
			System.exit(0);
		}
	}
}
