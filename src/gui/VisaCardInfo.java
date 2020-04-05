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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VisaCardInfo {

	public static void editVisaWindow(Customer customer) {
		Stage visaEditWindow = new Stage();
		visaEditWindow.initModality(Modality.APPLICATION_MODAL);
		visaEditWindow.setTitle("Update your visa information");
		
		GridPane grid = new GridPane();
		grid.setVgap(10);
		grid.setHgap(10);
		grid.setPadding(new Insets(100, 100, 100, 100));
		
		Label visaCardNumber = new Label("Enter Visa Card Number");
		Label pinLbl = new Label("Enter your PIN code");
		Label balanceLbl = new Label("Enter current balance");
		
		TextField visaCardNumberTxt = new TextField();
		PasswordField pinTxt = new PasswordField();
		TextField balanceTxt = new TextField();
		
		Button doneButton = new Button("Done");
		
		grid.add(visaCardNumber, 0, 0);
		grid.add(pinLbl, 0, 1);
		grid.add(balanceLbl, 0, 2);
		grid.add(visaCardNumberTxt, 1, 0);
		grid.add(pinTxt, 1, 1);
		grid.add(balanceTxt, 1, 2);
		grid.add(doneButton, 1, 3);
		
		doneButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				customer.setVisaCardNumber(visaCardNumberTxt.getText());
				customer.setVisaCardPinCode(pinTxt.getText());
				customer.setBalance(Double.parseDouble(balanceTxt.getText()));
				visaEditWindow.close();
				
			}
		});
		
		Scene scene = new Scene(grid, 500, 300);
		visaEditWindow.setScene(scene);
		visaEditWindow.showAndWait();
	}
		
	}


