package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.xml.bind.JAXBException;

import customers.Customer;
import employees.Cook;
import employees.Manager;
import employees.Waiter;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox; 
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import restaurant.Order;
import restaurant.food.Dish;
import restaurant.table.Table;
import restaurantReservationSystem.Date;
import restaurantReservationSystem.Person;
import xmlHandlers.DishX;
import xmlHandlers.Restaurant;
import xmlHandlers.XMLFileHandler;

public class Dashboard {
	
	private static void showProfile(Person person, GridPane mainScreenArea) {
		
		String passIcon = "";
		String typeString;
		Label header = new Label("Profile");
		header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label name = new Label("Name:\t\t" + person.getName());
		if (person instanceof Customer) 
			typeString = "customer";
		else if (person instanceof Manager)
			typeString = "manager";
		else if (person instanceof Cook)
			typeString = "cook";
		else 
			typeString = "waiter";
		Label accountType = new Label ("Account Type:\t" + typeString);
		Label username = new Label("username:\t\t" + person.getUsername());
		for(int i = 0; i < person.getPassword().length(); i++) {
			passIcon = passIcon.concat("*");
		}
		Label password = new Label("password:\t\t" + passIcon);
		
		mainScreenArea.getChildren().clear();
		mainScreenArea.add(header, 0, 0);
		mainScreenArea.add(name, 0, 1);
		mainScreenArea.add(accountType, 0, 2);
		mainScreenArea.add(username, 0, 3);
		mainScreenArea.add(password, 0, 4);
	}
	
	private static void showSettings(Person person, GridPane mainScreenArea) {
		
		Label header = new Label("Settings");
		header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		String passIcon = "";
		String typeString;
		Label name = new Label("Name:\t\t" + person.getName());
		if (person instanceof Customer) 
			typeString = "customer";
		else if (person instanceof Manager)
			typeString = "manager";
		else if (person instanceof Cook)
			typeString = "cook";
		else 
			typeString = "waiter";
		Label accountType = new Label ("Account Type:\t" + typeString);
		Label username = new Label("username:\t\t" + person.getUsername());
		for(int i = 0; i < person.getPassword().length(); i++) {
			passIcon = passIcon.concat("*");
		}
		Label password = new Label("password:\t\t" + passIcon);
		
		Label spacer = new Label("\t\t\t\t\t\t\n\n\n");
		
		Button editName = new Button("edit");
		Button editUserName = new Button("edit");
		Button editPassword = new Button("edit");
		Button save = new Button("Save");
		
		mainScreenArea.getChildren().clear();
		mainScreenArea.add(header, 0, 0);
		mainScreenArea.add(name, 0, 1);
		mainScreenArea.add(accountType, 0, 2);
		mainScreenArea.add(username, 0, 3);
		mainScreenArea.add(password, 0, 4);
		
		mainScreenArea.add(editName, 1, 1);
		mainScreenArea.add(editUserName, 1, 3);
		mainScreenArea.add(editPassword, 1, 4);
		mainScreenArea.add(save, 3, 6);
		mainScreenArea.add(spacer, 2, 5);
		
		//edit buttons actions
		editName.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				editNameField(person);
				showSettings(person, mainScreenArea);
				
			}
		});
		

		editUserName.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				editUserNameField(person);
				showSettings(person, mainScreenArea);
				
			}
		});
		
		editPassword.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				editPasswordField(person);
				showSettings(person, mainScreenArea);
				
			}
		});
		
		//TODO: save button calls xml handling class
	}
	
	private static void editNameField(Person person) {
		
		Stage editWindow = new Stage();
		editWindow.initModality(Modality.APPLICATION_MODAL);
		editWindow.setTitle("Edit Name");
		VBox vbox = new VBox();
		Label label = new Label("Enter new name");
		TextField textField = new TextField();
		Button button = new Button("Done");
		vbox.getChildren().addAll(label, textField, button);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				person.setName(textField.getText());
				editWindow.close();
				
			}
		});
	
		
		vbox.setAlignment(Pos.BASELINE_CENTER);
		
		Scene scene = new Scene(vbox, 450, 250);
		editWindow.setScene(scene);
		editWindow.showAndWait();
		
	}
	
	private static void editUserNameField(Person person) {
		
		Stage editWindow = new Stage();
		editWindow.initModality(Modality.APPLICATION_MODAL);
		editWindow.setTitle("Edit Username");
		VBox vbox = new VBox();
		Label label = new Label("Enter new username");
		TextField textField = new TextField();
		Button button = new Button("Done");
		vbox.getChildren().addAll(label, textField, button);
		
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				person.setUsername(textField.getText());
				editWindow.close();
				
			}
		});
	
		
		vbox.setAlignment(Pos.BASELINE_CENTER);
		
		Scene scene = new Scene(vbox, 450, 250);
		editWindow.setScene(scene);
		editWindow.showAndWait();
		
		
	}

	private static void editPasswordField(Person person) {
	
		Stage editWindow = new Stage();
		editWindow.initModality(Modality.APPLICATION_MODAL);
		editWindow.setTitle("Edit Password");
		GridPane grid = new GridPane();
		grid.setVgap(5);
		grid.setHgap(5);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		Label labelOld = new Label("Enter old password:");
		Label labelNew = new Label("Enter new password: ");
		Label labelCheck = new Label("Enter new password again: ");
		PasswordField oldPass = new PasswordField();
		PasswordField newPass = new PasswordField();
		PasswordField checkPass = new PasswordField();
		Button done = new Button("Done");
		
		Label message = new Label();
		
		grid.add(labelOld, 0, 0);
		grid.add(labelNew, 0, 1);
		grid.add(labelCheck, 0, 2);
		
		grid.add(oldPass, 1, 0);
		grid.add(newPass, 1, 1);
		grid.add(checkPass, 1, 2);
		
		grid.add(message, 0, 3, 2, 1);
		
		grid.add(done, 0, 4, 2, 1);
		GridPane.setHalignment(done, HPos.CENTER);
		GridPane.setHalignment(message, HPos.CENTER);
		
		done.setOnAction(new EventHandler<ActionEvent>() {
	
			@Override
			public void handle(ActionEvent event) {
				if (!oldPass.getText().equals(person.getPassword())) {
					message.setText("Password Incorrect!");
					message.setTextFill(Color.web("#ff0000", 0.8));
				} else if (!newPass.getText().equals(checkPass.getText())) {
					message.setText("Passwords don't match!");
					message.setTextFill(Color.web("#ff0000", 0.8));
				} else {
					person.setPassword(newPass.getText());
					editWindow.close();
				}
				
			}
		});
		
		Scene scene = new Scene(grid, 450, 250);
		editWindow.setScene(scene);
		editWindow.showAndWait();
	}
	private static void logoutConfirmation(Stage currentStage) {
		
		Stage logoutConfirm = new Stage();
		logoutConfirm.initModality(Modality.APPLICATION_MODAL);
		logoutConfirm.setTitle("Confirm");
		
		Label label = new Label("Are you sure you wish to log out?");
	    Button yes = new Button("Yes");
	    Button no = new Button("No");
	    yes.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				LoginScreen.loginScreen(new Stage());
				currentStage.close();
				logoutConfirm.close();
			}
		
		});
	   
	   no.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				logoutConfirm.close();
			}
	   });
	    
	    GridPane grid = new GridPane();
	    grid.setVgap(10);
	    grid.setHgap(10);
	    grid.setPadding(new Insets(100, 100, 100, 125));
	    grid.add(label, 0, 0, 2, 1);
	    grid.add(yes, 0, 1);
	    grid.add(no, 1, 1);
	    
	    GridPane.setHalignment(label, HPos.CENTER);
	    GridPane.setHalignment(yes, HPos.LEFT);
	    GridPane.setHalignment(no, HPos.RIGHT);
	
		
		Scene scene = new Scene(grid, 450, 250);
		logoutConfirm.setScene(scene);
		logoutConfirm.showAndWait();
	}

	public static void showCustomer(Customer customer, Stage stage, Restaurant restaurant) throws FileNotFoundException {
		
		//Layout
		
		stage.setTitle("Dashboard");
		
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
		Button viewOrderButton = new Button("View order");
		Button makeNewOrderButton = new Button("Make a reservation");
		makeOrderGrid.add(viewOrderButton, 0, 0);
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

		
		GridPane mainScreenArea = new GridPane();
		border.setCenter(mainScreenArea);
		mainScreenArea.setPadding(new Insets(10, 10, 10, 10));
        mainScreenArea.setVgap(8);
        mainScreenArea.setHgap(10);
        
        mainScreenArea.add(name, 0, 0);
        
        GridPane.setHalignment(logOutButton, HPos.RIGHT);
        
        //Buttons functionality:
        
        //viewProfileButton
        viewProfileButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				showProfile(customer, mainScreenArea);
				
			}
		});
        //settingsButton
        settingsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSettings(customer, mainScreenArea);
				
			}
		});
        //viewOrderButton
        viewOrderButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainScreenArea.getChildren().clear();
				Label header = new Label("Order review");
				header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
				
		        mainScreenArea.add(header, 0, 0);
		        
		        Order order = new Order();
				order.setDishes(restaurant.getMenu());
				customer.setCurrentOrder(order);
		        
				TableView<Dish> table = new TableView<>();
				
				TableColumn<Dish, String> dishName = new TableColumn<>("Dish");
				dishName.setMinWidth(200);
				dishName.setCellValueFactory(new PropertyValueFactory<>("name"));
				
				TableColumn<Dish, Double> dishPrice = new TableColumn<>("Price");
				dishPrice.setMinWidth(100);
				dishPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
				
				table.setItems(restaurant.retrieveDishes());
				table.getColumns().add(dishName);
				table.getColumns().add(dishPrice);
				
				mainScreenArea.add(table, 0, 1);		
			}
		});
        //makeNewOrderButton
        makeNewOrderButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainScreenArea.getChildren().clear();
				Label header = new Label("Reserve a table");
				header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
				
				
				ComboBox<Table> checkAvailable = new ComboBox<>(restaurant.retrieveAvailableTables());
				checkAvailable.setPromptText("Check available tables");
				Button selectButton = new Button("Select");
				mainScreenArea.add(header, 0, 0);
				mainScreenArea.add(checkAvailable, 0, 1);
				mainScreenArea.add(selectButton, 1, 2);
				
				selectButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						//TODO: add to customer's order this table
						//TODO: redirect to selecting dishes
						
					}
				});	
			}
		});
        //logOutButton
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				logoutConfirmation(stage);	
				
			}
		});
        //reviewUsButton
        reviewUsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainScreenArea.getChildren().clear();
				Label header = new Label("Review us");
				header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			
				Label addComment = new Label("Please add any comments about our service.");
				TextField comment = new TextField();
				comment.setPrefSize(200, 200);
				Button done = new Button("Done");
				
				mainScreenArea.add(header, 0, 0);
				mainScreenArea.add(addComment, 0, 1);
				mainScreenArea.add(comment, 0, 2);
				mainScreenArea.add(done, 0, 3);
				
				done.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						//restaurant.getReviews().getReviews().add(comment.getText());
						mainScreenArea.getChildren().clear();
						Label header = new Label("Thank You!");
						header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
						mainScreenArea.add(header, 0, 0);
						
					}
				});
				
			}
		});
        
        
        Scene scene = new Scene(border, 700, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
	public static void showManager(Manager manager, Stage stage) throws FileNotFoundException {
		
		stage.setTitle("Dashboard");
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

		
		GridPane mainScreenArea = new GridPane();
		border.setCenter(mainScreenArea);
		mainScreenArea.setPadding(new Insets(10, 10, 10, 10));
        mainScreenArea.setVgap(8);
        mainScreenArea.setHgap(10);
        
        mainScreenArea.add(name, 0, 0);
        
        GridPane.setHalignment(logOutButton, HPos.RIGHT);
        
        //buttons functionality
 viewProfileButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				showProfile(manager, mainScreenArea);
				
			}
		});
        //settingsButton
        settingsButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				showSettings(manager, mainScreenArea);
				
			}
        });
        
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				logoutConfirmation(stage);
				
			}
        });
        
        Scene scene = new Scene(border, 700, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
	public static void showCook(Cook cook, Stage stage) throws FileNotFoundException {

		
		stage.setTitle("Dashboard");
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

		
		GridPane mainScreenArea = new GridPane();
		border.setCenter(mainScreenArea);
		mainScreenArea.setPadding(new Insets(10, 10, 10, 10));
        mainScreenArea.setVgap(8);
        mainScreenArea.setHgap(10);
        
        mainScreenArea.add(name, 0, 0);
        
        GridPane.setHalignment(logOutButton, HPos.RIGHT);
        
      //buttons functionality
        viewProfileButton.setOnAction(new EventHandler<ActionEvent>() {
       			
       		@Override
       		public void handle(ActionEvent event) {
       			showProfile(cook, mainScreenArea);
       				
       		}
       	});
        //settingsButton
        settingsButton.setOnAction(new EventHandler<ActionEvent>() {

       		@Override
       		public void handle(ActionEvent event) {
       			showSettings(cook, mainScreenArea);
       				
       		}
        });
               
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {

       		@Override
       		public void handle(ActionEvent event) {
       			logoutConfirmation(stage);
       				
       		}
        });
        
        Scene scene = new Scene(border, 700, 500);
        
        stage.setScene(scene);
        stage.show();
	}
	
	public static void showWaiter(Waiter waiter, Stage stage) throws FileNotFoundException {
		
		stage.setTitle("Dashboard");
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
		
		GridPane mainScreenArea = new GridPane();
		border.setCenter(mainScreenArea);
		mainScreenArea.setPadding(new Insets(10, 10, 10, 10));
        mainScreenArea.setVgap(8);
        mainScreenArea.setHgap(10);
        
        GridPane.setHalignment(logOutButton, HPos.RIGHT);
        
      //buttons functionality
        viewProfileButton.setOnAction(new EventHandler<ActionEvent>() {
       			
       		@Override
       		public void handle(ActionEvent event) {
       			showProfile(waiter, mainScreenArea);
       				
       		}
       	});
      //settingsButton
        settingsButton.setOnAction(new EventHandler<ActionEvent>() {

       		@Override
       		public void handle(ActionEvent event) {
       			showSettings(waiter, mainScreenArea);
       				
       		}
        });
               
        logOutButton.setOnAction(new EventHandler<ActionEvent>() {

       		@Override
       		public void handle(ActionEvent event) {
       			logoutConfirmation(stage);
       				
       		}
        });
        
        Scene scene = new Scene(border, 700, 500);
        
        stage.setScene(scene);
        stage.show();
	}
}
