/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class DialogDesignController  {

    @FXML
    ToggleButton playbtn;
    @FXML
    ToggleButton hostbtn;
    
    
    public void initialize() {
        playbtn.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {
            	String[] args = {};
				Client.main(args);
					
            }
        });
        hostbtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
            	String[] args = {};
            	try {
					Server.main(args);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        });
    }

}
