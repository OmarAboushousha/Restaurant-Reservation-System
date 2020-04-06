package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FileLoadError {

	public static void display() {
		Stage errorWindow = new Stage();
		errorWindow.setTitle("Error!");

		Label label = new Label("Error loading file!");
		Button button = new Button("Exit");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				errorWindow.close();

			}
		});


		VBox vbox = new VBox(8, label, button);


		vbox.setAlignment(Pos.CENTER);

		Scene scene = new Scene(vbox, 450, 250);
		errorWindow.setScene(scene);
		errorWindow.show();
	}
}
