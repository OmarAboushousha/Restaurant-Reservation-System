package gui;

import customers.Customer;
import employees.Cook;
import employees.Manager;
import employees.Waiter;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Dashboard {

	public static void showCustomer(Customer customer, Stage stage) {
		
		Label name = new Label("Welcome " + customer.getName() + "!");
		Label type = new Label("User Type: Customer");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        grid.add(name, 0, 0);
        grid.add(type, 0, 1);
        
        Scene scene = new Scene(grid, 600, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
	public static void showManager(Manager manager, Stage stage) {
		
		Label name = new Label("Welcome " + manager.getName() + "!");
		Label type = new Label("User Type: Manager");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        grid.add(name, 0, 0);
        grid.add(type, 0, 1);
        
        Scene scene = new Scene(grid, 600, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
	public static void showCook(Cook cook, Stage stage) {

			Label name = new Label("Welcome " + cook.getName() + "!");
			Label type = new Label("User Type: Cook");
			
			GridPane grid = new GridPane();
			grid.setPadding(new Insets(10, 10, 10, 10));
	        grid.setVgap(8);
	        grid.setHgap(10);
	        
	        grid.add(name, 0, 0);
	        grid.add(type, 0, 1);
	        
	        Scene scene = new Scene(grid, 600, 500);
	        
	        stage.setScene(scene);
	        stage.show();
		}
	
	public static void showWaiter(Waiter waiter, Stage stage) {
		
		Label name = new Label("Welcome " + waiter.getName() + "!");
		Label type = new Label("User Type: Waiter");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
        grid.add(name, 0, 0);
        grid.add(type, 0, 1);
        
        Scene scene = new Scene(grid, 600, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
}
