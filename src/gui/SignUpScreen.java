package gui;



import java.io.FileNotFoundException;

import javax.xml.bind.JAXBException;

import customers.Customer;
import employees.Cook;
import employees.Manager;
import employees.Waiter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import restaurantReservationSystem.Person;
import xmlHandlers.Restaurant;
import xmlHandlers.XMLFileHandler;

public class SignUpScreen {

	public static void displaySignUpScreen(GridPane grid, Restaurant restaurant, Stage signUpStage) {
		grid.getChildren().clear();
		
		ObservableList<Person> usersList = FXCollections.observableArrayList();
		usersList.addAll(new Customer(), new Manager(), new Cook(), new Waiter());
		
		TextField nameField = new TextField();
		TextField username = new TextField();
		PasswordField newPass = new PasswordField();
		PasswordField confirmPass = new PasswordField();
		ComboBox<Person> userTypeChoice = new ComboBox<>();
		userTypeChoice.setItems(usersList);;
		userTypeChoice.setPromptText("Account Type");
		Button signUpButton = new Button ("Sign up");
		Button cancelButton = new Button("Cancel");
		
		grid.add(new Label("Enter Name"), 0, 0);
		grid.add(new Label("Enter Username"), 0, 1);
		grid.add(new Label("Enter Password"), 0, 2);
		grid.add(new Label("Confirm Password"), 0, 3);
		grid.add(new Label("Choose User Type"), 0, 4);
		
		grid.add(nameField, 1, 0);
		grid.add(username, 1, 1);
		grid.add(newPass, 1, 2);
		grid.add(confirmPass, 1, 3);
		grid.add(userTypeChoice, 1, 4);
		
		grid.add(signUpButton, 1, 5);
		grid.add(cancelButton, 0, 5);
		
		signUpButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				if (nameField.getText() == null || username.getText() == null || newPass.getText() == null
						|| !confirmPass.getText().equals(newPass.getText()) || userTypeChoice.getValue() == null) {
					AlertBox.display("Please enter correct information");
					return;
				}
				for (Person element : restaurant.getPersons()) {
					if (username.getText().equals(element.getUsername())) {
						AlertBox.display("Username already exists.\nPlease choose another username.\nSuggestion: " + nameField.getText() + "2020");
						return;
					}
				}
				
				userTypeChoice.getValue().setName(nameField.getText());
				userTypeChoice.getValue().setUsername(username.getText());
				userTypeChoice.getValue().setPassword(newPass.getText());
				
				
				if (userTypeChoice.getValue() instanceof Customer) {
					Customer customer = (Customer) userTypeChoice.getValue();
					restaurant.getPersons().add(customer);
					try {
						XMLFileHandler.saveFile(restaurant, "Data.xml");
						Dashboard.showCustomer(customer, signUpStage, restaurant);
					} catch (FileNotFoundException | JAXBException e) {
						// TODO Auto-generated catch block
						AlertBox.display("Unexpected Error!");;
					}
					
				} else if (userTypeChoice.getValue() instanceof Manager) {
					enterCodePrompt(Manager.getManagerCode(), userTypeChoice.getValue(), signUpStage, restaurant);
					
				} else if (userTypeChoice.getValue() instanceof Cook) {
					enterCodePrompt(Cook.getCookCode(), userTypeChoice.getValue(),signUpStage, restaurant);
					
				} else if (userTypeChoice.getValue() instanceof Waiter) {
					enterCodePrompt(Waiter.getWaiterCode(), userTypeChoice.getValue(), signUpStage, restaurant);
					
				}
				
			}
		});
		
		
		cancelButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				LoginScreen.loginScreen(signUpStage);
				
			}
		});
		
		
	}

	private static void enterCodePrompt(String code, Person person, Stage signUpStage, Restaurant restaurant) {
		Stage codeWindow = new Stage();
		codeWindow.initModality(Modality.APPLICATION_MODAL);
		codeWindow.setTitle("Code");
		

		VBox vbox = new VBox(8);
		TextField codeTxt = new TextField();
		Button button = new Button("Confirm");
		
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (codeTxt.getText().equals(code)) {
					if (person instanceof Manager) {
						Manager manager = (Manager) person;
						restaurant.getPersons().add(manager);
						try {
							XMLFileHandler.saveFile(restaurant, "Data.xml");
							Dashboard.showManager(manager, signUpStage, restaurant);
						} catch (FileNotFoundException | JAXBException e) {
							// TODO Auto-generated catch block
							AlertBox.display("Unexpected Error!");
						}						
					} else if (person instanceof Cook) {
						Cook cook = (Cook) person;
						restaurant.getPersons().add(cook);
						try {
							XMLFileHandler.saveFile(restaurant, "Data.xml");
							Dashboard.showCook(cook, signUpStage, restaurant);
						} catch (FileNotFoundException | JAXBException e) {

							// TODO Auto-generated catch block
							AlertBox.display("Unexpected Error!");
						}							
					} else if (person instanceof Waiter) {
						Waiter waiter = (Waiter) person;
						restaurant.getPersons().add(waiter);
						try {
							XMLFileHandler.saveFile(restaurant, "Data.xml");
							Dashboard.showWaiter(waiter, signUpStage, restaurant);
						} catch (FileNotFoundException | JAXBException e) {

							// TODO Auto-generated catch block
							AlertBox.display("Unexpected Error!");
						}							
					}
				}
				else AlertBox.display("Incorrect Code");
				
				codeWindow.close();

			}
		});
		vbox.getChildren().addAll(new Label("Enter Account code"), codeTxt, button);
		
		vbox.setAlignment(Pos.BASELINE_CENTER);
		
		Scene scene = new Scene(vbox, 500, 300);
		codeWindow.setScene(scene);
		codeWindow.showAndWait();
		}
}
		
