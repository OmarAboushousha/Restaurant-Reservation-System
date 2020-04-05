package gui;

import java.io.FileNotFoundException;

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

public class LoginScreen {
	public static void loginScreen(Stage loginScreen) {
<<<<<<< HEAD
//		try {
//			Dashboard.showCustomer(new Customer("ahmed", "js", "eje"), loginScreen, restaurant);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
=======
		/*try {
			Dashboard.showCustomer(new Customer("ahmed", "js", "eje"), loginScreen, restaurant);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
>>>>>>> 7311d950914a41105a1adb07b2ee67d06e253b07
		try {
			
			Restaurant restaurant = XMLFileHandler.LoadFile("Data.xml");

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
			
			customerUser.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					staffUser.setSelected(false);
				}
			});
			staffUser.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					customerUser.setSelected(false);	
				}
			});
			Button loginButton = new Button("Log in");
			
			loginButton.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					Person person;
					person = Person.login(usernameInput.getText(), passwordInput.getText(), restaurant);
					
					if(person == null)
						LoginError.display("Invalid username or password.");
					else {
						if(staffUser.isSelected()) {
							if (person instanceof Employee) {
								//TODO: redirect to staff type dashboard
								if(person instanceof Manager) {
									Manager manager = new Manager(person.getName(),
											person.getUsername(), person.getPassword());
									try {
										Dashboard.showManager(manager, loginScreen);
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									loginScreen.setTitle("Manager Dashboard");
																	
								}
								if(person instanceof Waiter) {
									Waiter waiter = new Waiter(person.getName(), person.getUsername(),
											person.getPassword());
									try {
										Dashboard.showWaiter(waiter, loginScreen);
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									loginScreen.setTitle("Waiter Dashboard");
									
								}
								if(person instanceof Cook) {
									Cook cook = new Cook(person.getName(), person.getUsername(),
											person.getPassword());
									try {
										Dashboard.showCook(cook, loginScreen);
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									loginScreen.setTitle("Cook Dashboard");
									
									
								}
							}
							else LoginError.display("Please choose correct type of user.");
						}
						else if (customerUser.isSelected()) {
							if (person instanceof Customer) {
								//TODO: redirect to customer dashboard
								Customer customer = new Customer(person.getName(),
										person.getUsername(), person.getPassword());
								try {
									Dashboard.showCustomer(customer, loginScreen, restaurant);
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								loginScreen.setTitle("Customer Dashboard");
							}
							else LoginError.display("Please choose correct type of user.");
						} else LoginError.display("Please choose correct type of user.");
					}
				}
			});
			
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
			
				
		} catch (JAXBException e) {
			FileLoadError.display();
		}
	}

}
