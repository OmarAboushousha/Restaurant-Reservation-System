package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import customers.Customer;
import employees.Cook;
import employees.Manager;
import employees.Waiter;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Dashboard {

	public static void showCustomer(Customer customer, Stage stage) throws FileNotFoundException {
		
		BorderPane border = new BorderPane();
		Accordion accordion = new Accordion();
		border.setLeft(accordion);
		
		//Contents of Accordion:
		
		TitledPane profilePane = new TitledPane();
		profilePane.setText("Profile");
		GridPane profileGrid = new GridPane();
		profileGrid.setVgap(4);
		profileGrid.setPadding(new Insets(5, 5, 5, 5));
		Button viewProfileButton = new Button("View Profile");
		Button settingsButton = new Button("Settings");
		profileGrid.add(viewProfileButton, 0, 0);
		profileGrid.add(settingsButton, 0, 1);
		profilePane.setContent(profileGrid);
		
		TitledPane orderPane = new TitledPane();
		orderPane.setText("Orders");
		GridPane makeOrderGrid = new GridPane();
		makeOrderGrid.setVgap(4);
		makeOrderGrid.setPadding(new Insets(5, 5, 5, 5));
		Button orderHistoryButton = new Button("View history");
		Button makeNewOrderButton = new Button("Make a reservation");
		makeOrderGrid.add(orderHistoryButton, 0, 0);
		makeOrderGrid.add(makeNewOrderButton, 0, 1);
		orderPane.setContent(makeOrderGrid);
		
		accordion.getPanes().addAll(profilePane, orderPane);
		
		//Image Header and toolbar
		
		ToolBar toolbar = new ToolBar();
		Button logOutButton = new Button("Log out");
		Button reviewUsButton = new Button("Review us");
		HBox spacer = new HBox();                 
	    HBox.setHgrow(spacer, Priority.ALWAYS);
		toolbar.getItems().addAll(spacer, logOutButton, reviewUsButton);
		
		Image image = new Image(new FileInputStream("header image.jpg"));
		ImageView imageView = new ImageView(image); 
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(toolbar, imageView);
		border.setTop(vbox);
		
		//Main Screen Area
		Label name = new Label("Welcome " + customer.getName() + "!");
		name.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label type = new Label("Account Type: Customer");

		
		GridPane mainScreenArea = new GridPane();
		border.setCenter(mainScreenArea);
		mainScreenArea.setPadding(new Insets(10, 10, 10, 10));
        mainScreenArea.setVgap(8);
        mainScreenArea.setHgap(10);
        
        mainScreenArea.add(name, 0, 0);
        mainScreenArea.add(type, 0, 1);
        
        GridPane.setHalignment(logOutButton, HPos.RIGHT);
        
        Scene scene = new Scene(border, 700, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
	public static void showManager(Manager manager, Stage stage) throws FileNotFoundException {
		
		BorderPane border = new BorderPane();
		Accordion accordion = new Accordion();
		border.setLeft(accordion);
		
		//Contents of Accordion:
		
		TitledPane profilePane = new TitledPane();
		profilePane.setText("Profile");
		GridPane profileGrid = new GridPane();
		profileGrid.setVgap(4);
		profileGrid.setPadding(new Insets(5, 5, 5, 5));
		Button viewProfileButton = new Button("View Profile");
		Button settingsButton = new Button("Settings");
		profileGrid.add(viewProfileButton, 0, 0);
		profileGrid.add(settingsButton, 0, 1);
		profilePane.setContent(profileGrid);
		
		TitledPane orderPane = new TitledPane();
		orderPane.setText("Orders");
		GridPane orderGrid = new GridPane();
		orderGrid.setVgap(4);
		orderGrid.setPadding(new Insets(5, 5, 5, 5));
		Button viewOrdersButton = new Button("View orders");
		Button editMenuButton = new Button("Edit Menu");
		orderGrid.add(viewOrdersButton, 0, 0);
		orderGrid.add(editMenuButton, 0, 1);
		orderPane.setContent(orderGrid);
		
		TitledPane statPane = new TitledPane();
		statPane.setText("Statistics");
		GridPane statGrid = new GridPane();
		statGrid.setVgap(4);
		statGrid.setPadding(new Insets(5, 5, 5, 5));
		Button viewStatButton = new Button("View statistics");
		statGrid.add(viewStatButton, 0, 0);
		statPane.setContent(statGrid);
		
		accordion.getPanes().addAll(profilePane, orderPane, statPane);
		
		//Image Header and toolbar
		
		ToolBar toolbar = new ToolBar();
		Button logOutButton = new Button("Log out");
		HBox spacer = new HBox();                 
	    HBox.setHgrow(spacer, Priority.ALWAYS);
		toolbar.getItems().addAll(spacer, logOutButton);
		
		Image image = new Image(new FileInputStream("header image.jpg"));
		ImageView imageView = new ImageView(image); 
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(toolbar, imageView);
		border.setTop(vbox);
		
		//Main Screen Area
		Label name = new Label("Welcome " + manager.getName() + "!");
		name.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label type = new Label("Account Type: Manager");

		
		GridPane mainScreenArea = new GridPane();
		border.setCenter(mainScreenArea);
		mainScreenArea.setPadding(new Insets(10, 10, 10, 10));
        mainScreenArea.setVgap(8);
        mainScreenArea.setHgap(10);
        
        mainScreenArea.add(name, 0, 0);
        mainScreenArea.add(type, 0, 1);
        
        GridPane.setHalignment(logOutButton, HPos.RIGHT);
        
        Scene scene = new Scene(border, 700, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
	public static void showCook(Cook cook, Stage stage) throws FileNotFoundException {

		BorderPane border = new BorderPane();
		Accordion accordion = new Accordion();
		border.setLeft(accordion);
		
		//Contents of Accordion:
		
		TitledPane profilePane = new TitledPane();
		profilePane.setText("Profile");
		GridPane profileGrid = new GridPane();
		profileGrid.setVgap(4);
		profileGrid.setPadding(new Insets(5, 5, 5, 5));
		Button viewProfileButton = new Button("View Profile");
		Button settingsButton = new Button("Settings");
		profileGrid.add(viewProfileButton, 0, 0);
		profileGrid.add(settingsButton, 0, 1);
		profilePane.setContent(profileGrid);
		
		TitledPane orderPane = new TitledPane();
		orderPane.setText("Orders");
		GridPane orderGrid = new GridPane();
		orderGrid.setVgap(4);
		orderGrid.setPadding(new Insets(5, 5, 5, 5));
		Button viewOrdersButton = new Button("View orders");
		Button editMenuButton = new Button("Edit Menu");
		orderGrid.add(viewOrdersButton, 0, 0);
		orderGrid.add(editMenuButton, 0, 1);
		orderPane.setContent(orderGrid);
		
		accordion.getPanes().addAll(profilePane, orderPane);
		
		//Image Header and toolbar
		
		ToolBar toolbar = new ToolBar();
		Button logOutButton = new Button("Log out");
		HBox spacer = new HBox();                 
	    HBox.setHgrow(spacer, Priority.ALWAYS);
		toolbar.getItems().addAll(spacer, logOutButton);
		
		Image image = new Image(new FileInputStream("cook header.jpg"));
		ImageView imageView = new ImageView(image); 
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(toolbar, imageView);
		border.setTop(vbox);
		
		//Main Screen Area
		Label name = new Label("Welcome " + cook.getName() + "!");
		name.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label type = new Label("Account Type: Cook");

		
		GridPane mainScreenArea = new GridPane();
		border.setCenter(mainScreenArea);
		mainScreenArea.setPadding(new Insets(10, 10, 10, 10));
        mainScreenArea.setVgap(8);
        mainScreenArea.setHgap(10);
        
        mainScreenArea.add(name, 0, 0);
        mainScreenArea.add(type, 0, 1);
        
        GridPane.setHalignment(logOutButton, HPos.RIGHT);
        
        Scene scene = new Scene(border, 700, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
	public static void showWaiter(Waiter waiter, Stage stage) throws FileNotFoundException {
		BorderPane border = new BorderPane();
		Accordion accordion = new Accordion();
		border.setLeft(accordion);
		
		//Contents of Accordion:
		
		TitledPane profilePane = new TitledPane();
		profilePane.setText("Profile");
		GridPane profileGrid = new GridPane();
		profileGrid.setVgap(4);
		profileGrid.setPadding(new Insets(5, 5, 5, 5));
		Button viewProfileButton = new Button("View Profile");
		Button settingsButton = new Button("Settings");
		profileGrid.add(viewProfileButton, 0, 0);
		profileGrid.add(settingsButton, 0, 1);
		profilePane.setContent(profileGrid);
		
		TitledPane orderPane = new TitledPane();
		orderPane.setText("Orders");
		GridPane orderGrid = new GridPane();
		orderGrid.setVgap(4);
		orderGrid.setPadding(new Insets(5, 5, 5, 5));
		Button viewOrdersButton = new Button("View orders");
		orderGrid.add(viewOrdersButton, 0, 0);
		orderPane.setContent(orderGrid);
		
		accordion.getPanes().addAll(profilePane, orderPane);
		
		//Image Header and toolbar
		
		ToolBar toolbar = new ToolBar();
		Button logOutButton = new Button("Log out");
		HBox spacer = new HBox();                 
	    HBox.setHgrow(spacer, Priority.ALWAYS);
		toolbar.getItems().addAll(spacer, logOutButton);
		
		Image image = new Image(new FileInputStream("header image.jpg"));
		ImageView imageView = new ImageView(image); 
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(toolbar, imageView);
		border.setTop(vbox);
		
		//Main Screen Area
		Label name = new Label("Welcome " + waiter.getName() + "!");
		name.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label type = new Label("Account Type: Waiter");
		
		GridPane mainScreenArea = new GridPane();
		border.setCenter(mainScreenArea);
		mainScreenArea.setPadding(new Insets(10, 10, 10, 10));
        mainScreenArea.setVgap(8);
        mainScreenArea.setHgap(10);
        
        mainScreenArea.add(name, 0, 0);
        mainScreenArea.add(type, 0, 1);
        
        GridPane.setHalignment(logOutButton, HPos.RIGHT);
        
        Scene scene = new Scene(border, 700, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
}
