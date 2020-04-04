package gui;

import javax.xml.bind.JAXBException;

import customers.Customer;
import employees.Cook;
import employees.Employee;
import employees.Manager;
import employees.Waiter;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import restaurantReservationSystem.Person;
import xmlHandlers.Restaurant;
import xmlHandlers.XMLFileHandler;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);	
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		LoginScreen.loginScreen(primaryStage);
		
	}

}
