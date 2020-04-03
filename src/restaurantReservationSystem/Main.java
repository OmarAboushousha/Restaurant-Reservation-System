package restaurantReservationSystem;

import javax.xml.bind.JAXBException;

import javafx.application.Application;
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
import xmlHandlers.Restaurant;
import xmlHandlers.XMLFileHandler;

public class Main extends Application {

	public static void main(String[] args) {
		//launch(args);
		try {
			Restaurant restaurant = XMLFileHandler.LoadFile("Data.xml");
			for (Person person: restaurant.getPersons())
			{
				System.out.println(person.getName() + " " + person.getUsername() + "\n");
			}
				
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	@Override
	public void start(Stage loginScreen) throws Exception {
		loginScreen.setTitle("Login");
		Label restaurantName = new Label("Spring View Restaurant");
		restaurantName.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		Label loginLabel = new Label("Login");
		loginLabel.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label username = new Label("Username");
		Label password = new Label("Password");
		TextField usernameInput = new TextField();
		usernameInput.setPromptText("username");
		PasswordField passwordInput = new PasswordField(); 
		passwordInput.setPromptText("password");
		RadioButton customerUser = new RadioButton("Customer");
		RadioButton staffUser = new RadioButton("Staff");
		Button loginButton = new Button("Log in");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(100, 100, 100, 125));
        grid.setVgap(8);
        grid.setHgap(10);
        
        grid.add(restaurantName, 0, 0, 2, 1);
        grid.add(loginLabel, 0, 1);
        grid.add(username, 0, 2);
        grid.add(password, 0, 3);
        grid.add(usernameInput, 1, 2);
        grid.add(passwordInput, 1, 3);
        grid.add(customerUser, 1, 4);
        grid.add(staffUser, 1, 4);
        grid.add(loginButton, 1, 6);
        
        GridPane.setHalignment(customerUser, HPos.RIGHT);
        GridPane.setHalignment(staffUser, HPos.LEFT);
        GridPane.setHalignment(loginButton, HPos.RIGHT);
         
        Scene scene = new Scene(grid, 600, 500);
        
        loginScreen.setScene(scene);
        loginScreen.show();
		
	}

}
