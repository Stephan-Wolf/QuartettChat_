/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class InfoController  {

	@FXML
	private void backbtn(ActionEvent event) throws IOException{
		Parent start_parent = FXMLLoader.load(getClass().getResource("Start.fxml"));
    	Scene start_scene = new Scene(start_parent); 
		Stage start_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		start_stage.setScene(start_scene);
		start_stage.show();
	}
}
