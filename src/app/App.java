package app;

/**
* App.java
* Startpunkt der Anwendung "Quartett mit Chat".
* Erstellt im Rahmen des Moduls "Pattern and Frameworks"
* an der Beuth Hochschule für Technik Berlin
*
* @author  Oliver Dusel
* @author  Christian Hechtberger
* @author  Artur Nowodworski
* @author  Stephan Wolf
* @version 1.0
* @since   2017/03 
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage window) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene scene = new Scene(root);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
