package gui;



import customers.Customer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import restaurant.Order;
import xmlHandlers.Restaurant;

public class VisaTransaction {
	public static void visaTransaction(Customer customer, Order order, Restaurant restaurant, GridPane mainScreenArea) {
		Stage visaWindow = new Stage();
		visaWindow.initModality(Modality.APPLICATION_MODAL);
		visaWindow.setTitle("Visa Transaction");

		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(100, 100, 100, 100));

		TextField accountNumText = new TextField();
		PasswordField pinText = new PasswordField();

		Label accountLbl = new Label("Enter account number");
		Label pinLbl = new Label("Enter PIN code");

		Button submitButton = new Button("Submit");

		grid.add(accountLbl, 0, 0);
		grid.add(pinLbl, 0, 1);
		grid.add(accountNumText, 1, 0);
		grid.add(pinText, 1, 1);
		grid.add(submitButton, 1, 2);

		submitButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if(customer.getBalance() > order.getPrice() && customer.getVisaCardNumber().equals(accountNumText.getText()) 
						&& customer.getVisaCardPinCode().equals(pinText.getText())) {
					order.setPaid(true);
					order.setCustomer(customer);
					customer.setCurrentOrder(order);
					customer.calculateBalance(order.calculatePrice());
					restaurant.getReservations().getOrders().add(order);
					AlertBox.display("Payment Successful");
					mainScreenArea.getChildren().clear();
					visaWindow.close();

				}
				else {
					AlertBox.display("Payment could not be completed.");
				}

			}
		});

		Scene scene = new Scene(grid, 500, 300);
		visaWindow.setScene(scene);
		visaWindow.showAndWait();
	}

}
