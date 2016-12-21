package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane; import javafx.stage.Stage;
import javafx.stage.WindowEvent;
public class Main2 extends Application {
		public static void main(String[] args) { launch(args);
	}
	@Override
	public void start(Stage stage) {
		StackPane pane = new StackPane();
		Button button = new Button();
		button.setText("Hier klicken");
		button.setOnAction(new EventHandler<ActionEvent>() { @Override
			public void handle(ActionEvent event) {
			Platform.exit();
		} });
		// button.setOnAction(event -> Platform.exit());
		pane.getChildren().add(button); stage.setScene(new Scene(pane, 400, 100));
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		@Override
		public void handle(WindowEvent event) {
		event.consume();
		} });
		// stage.setOnCloseRequest(event -> event.consume());
		stage.setTitle("Erstes Beispiel");
		stage.setResizable(false); stage.show();
	}
}
