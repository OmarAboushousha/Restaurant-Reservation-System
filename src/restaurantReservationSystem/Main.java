package restaurantReservationSystem;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
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
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage loginScreen) throws Exception {
		loginScreen.setTitle("Login");
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
		Button loginButton = new Button("Login");
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        grid.add(loginLabel, 0, 0);
        grid.add(username, 0, 1);
        grid.add(password, 0, 2);
        grid.add(usernameInput, 1, 1);
        grid.add(passwordInput, 1, 2);
        grid.add(customerUser, 1, 3);
        grid.add(staffUser, 1, 3);
        grid.add(loginButton, 1, 5);
        
        GridPane.setHalignment(customerUser, HPos.RIGHT);
        GridPane.setHalignment(staffUser, HPos.LEFT);
        GridPane.setHalignment(loginButton, HPos.LEFT);
        
        BorderPane border = new BorderPane();
        AnchorPane anchor = new AnchorPane();
        anchor.getChildren().add(grid);
        border.setCenter(anchor);
        
        
        
        Scene scene = new Scene(border, 600, 400);
        /*BackgroundImage myBI= new BackgroundImage(new Image("restauarant background.jpg",32,32,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                  BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));*/
        
        loginScreen.setScene(scene);
        loginScreen.show();
		
	}

}
