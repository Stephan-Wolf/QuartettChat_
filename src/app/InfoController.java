package app;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InfoController  {

	/**
	 * 
	 */
	@FXML
	private void backToStart(ActionEvent event) throws IOException{
		Parent start_parent = FXMLLoader.load(getClass().getResource("Start.fxml"));
    	Scene start_scene = new Scene(start_parent); 
		Stage start_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		start_stage.setScene(start_scene);
		start_stage.show();
	}
}
