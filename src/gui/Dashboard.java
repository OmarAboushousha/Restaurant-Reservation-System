package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import customers.Customer;
import employees.Cook;
import employees.Manager;
import employees.Waiter;
import javafx.collections.FXCollections;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
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
import restaurant.food.Appetizers;
import restaurant.food.Dish;
import restaurant.food.MainCourse;
import restaurant.table.Table;
import restaurantReservationSystem.Person;
import restaurantReservationSystem.Time;
import xmlHandlers.DishX;
import xmlHandlers.Restaurant;

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
		
		
		Button editName = new Button("edit");
		Button editUserName = new Button("edit");
		Button editPassword = new Button("edit");
		
		mainScreenArea.getChildren().clear();
		mainScreenArea.add(header, 0, 0);
		mainScreenArea.add(name, 0, 1);
		mainScreenArea.add(accountType, 0, 2);
		mainScreenArea.add(username, 0, 3);
		mainScreenArea.add(password, 0, 4);
		
		mainScreenArea.add(editName, 1, 1);
		mainScreenArea.add(editUserName, 1, 3);
		mainScreenArea.add(editPassword, 1, 4);
		
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


	private static void viewCustomerMenu(Order order, GridPane mainScreenArea, Restaurant restaurant, Customer customer) {
		
		
		mainScreenArea.getChildren().clear();
		Accordion accordion = new Accordion();
		
		Label header = new Label("Make your order");
		header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		
		TitledPane appetizersTitle = new TitledPane();
		GridPane appetizers = new GridPane();
		appetizers.setVgap(5);
		appetizers.setHgap(5);
		appetizers.setPadding(new Insets(5, 5, 5, 5));
		appetizersTitle.setText("Appetizers");
		appetizersTitle.setContent(appetizers);
		ObservableList<Dish> appetizersSelection = menuSelection(appetizers, "Appetizers", restaurant);
		
		TitledPane mainCourseTitle = new TitledPane();
		GridPane mainCourse = new GridPane();
		mainCourse.setVgap(5);
		mainCourse.setHgap(5);
		mainCourse.setPadding(new Insets(5, 5, 5, 5));
		mainCourseTitle.setText("Main Course");
		mainCourseTitle.setContent(mainCourse);
		ObservableList<Dish> mainCourseSelection = menuSelection(mainCourse, "Main Course", restaurant);
		
		TitledPane dessertsTitle = new TitledPane();
		GridPane desserts = new GridPane();
		desserts.setVgap(5);
		desserts.setHgap(5);
		desserts.setPadding(new Insets(5, 5, 5, 5));
		dessertsTitle.setText("Desserts");
		dessertsTitle.setContent(desserts);
		ObservableList<Dish> dessertSelection= menuSelection(desserts, "Desserts", restaurant);
	
		TitledPane drinksTitle = new TitledPane();
		GridPane drinks = new GridPane();
		drinks.setVgap(5);
		drinks.setHgap(5);
		drinks.setPadding(new Insets(5, 5, 5, 5));
		drinksTitle.setText("Drinks");
		drinksTitle.setContent(drinks);
		ObservableList<Dish> drinksSelection = menuSelection(drinks, "Drinks", restaurant);
		
		
		
		accordion.getPanes().addAll(appetizersTitle, mainCourseTitle, dessertsTitle, drinksTitle);
		
		Button confirmButton = new Button("Confirm Order");
		GridPane.setHalignment(confirmButton, HPos.LEFT);
		
		mainScreenArea.add(header, 0, 0);
		mainScreenArea.add(accordion, 0, 1);
		mainScreenArea.add(confirmButton, 1, 2);
		
		confirmButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				checkOut(customer, order, mainScreenArea, appetizersSelection, mainCourseSelection, dessertSelection, drinksSelection);
				
			}
		});
		
		
		
	}
	private static ObservableList<Dish> menuSelection(GridPane gridPane, String menuType, Restaurant restaurant) {
		gridPane.getChildren().clear();
		ColumnConstraints column1 = new ColumnConstraints(150, 150,
			        Double.MAX_VALUE);
			    ColumnConstraints column2 = new ColumnConstraints(50);
			    ColumnConstraints column3 = new ColumnConstraints(150, 150,
			        Double.MAX_VALUE);
			    column1.setHgrow(Priority.ALWAYS);
			    column3.setHgrow(Priority.ALWAYS);
			    gridPane.getColumnConstraints().addAll(column1, column2, column3);

			    Label menuLbl = new Label("Menu");
			    GridPane.setHalignment(menuLbl, HPos.CENTER);
			    gridPane.add(menuLbl, 0, 0);

			    Label selectedLbl = new Label("Your Selection");
			    gridPane.add(selectedLbl, 2, 0);
			    GridPane.setHalignment(selectedLbl, HPos.CENTER);
			    
			    //fetching the list
			    
			    ListView<Dish> menuList = new ListView<>(restaurant.retrieveDish(menuType));
			    gridPane.add(menuList, 0, 1);
			    
			    ObservableList<Dish> selected = FXCollections.observableArrayList();
			    ListView<Dish> selectedList = new ListView<>(selected);
			    gridPane.add(selectedList, 2, 1);

			    Button sendRightButton = new Button(" > ");
			    sendRightButton.setOnAction((ActionEvent event) -> {
			      Dish potential = menuList.getSelectionModel()
			          .getSelectedItem();
			      if (potential != null) {
			        menuList.getSelectionModel().clearSelection();
			        selected.add(potential);
			      }
			    });

			    Button sendLeftButton = new Button(" < ");
			    sendLeftButton.setOnAction((ActionEvent event) -> {
			      Dish s = selectedList.getSelectionModel().getSelectedItem();
			      if (s != null) {
			        selectedList.getSelectionModel().clearSelection();
			        selected.remove(s);
			      }
			    });
			    VBox vbox = new VBox(5);
			    vbox.getChildren().addAll(sendRightButton, sendLeftButton);

			    gridPane.add(vbox, 1, 1);
			    
			    return selected;
	}
	
	private static void checkOut(Customer customer, Order order, GridPane mainScreenArea, ObservableList<Dish> appetizers, ObservableList<Dish> mainCourse, ObservableList<Dish> desserts, ObservableList<Dish> drinks) {
		
		ObservableList<Dish> customerSelection = FXCollections.observableArrayList();
		
		for (int i = 0; i < appetizers.size(); i++) {
			customerSelection.add(appetizers.get(i));
		}
		
		for (int i = 0; i < mainCourse.size(); i++) {
			customerSelection.add(mainCourse.get(i));
		}
		
		for (int i = 0; i < desserts.size(); i++) {
			customerSelection.add(desserts.get(i));
		}
		
		for (int i = 0; i < drinks.size(); i++) {
			customerSelection.add(drinks.get(i));
		}
		
		for (int i = 0; i < customerSelection.size(); i++)
		{
			order.getDishes().add(customerSelection.get(i));
		}
		
		Label header = new Label("Checkout");
		header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		Label tableNum = new Label("Table number:\t" + order.getTable());
		Label orderDateAndTime = new Label("Date:\t" + order.getDate() + "\tTime:\t" + customer.getCurrentOrder().getDate());
		Label totalAmount = new Label("Total:\t" + order.calculatePrice());
		
		TableView<Dish> tableView = new TableView<Dish>();
		
		TableColumn<Dish, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        TableColumn<Dish, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        tableView.setItems(customerSelection);
        tableView.getColumns().addAll(nameColumn, priceColumn);
        
        Button checkOuButton = new Button ("Checkout");
        
        RadioButton cashButton = new RadioButton("Cash");
		RadioButton visaButton = new RadioButton("Visa");
		
		cashButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				visaButton.setSelected(false);
			}
		});
		visaButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				cashButton.setSelected(false);	
			}
		});
		
		checkOuButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (visaButton.isSelected()) 
				{
					if(!visaTransaction(customer, order)) {
						return;
					}
				}
				
				order.setCustomer(customer);
				customer.setCurrentOrder(order);
				
				
			}
		});
		

        
        mainScreenArea.add(header, 0, 0);
        mainScreenArea.add(tableNum, 0, 1);
        mainScreenArea.add(orderDateAndTime, 0, 2);
        mainScreenArea.add(tableView, 0, 3);
        mainScreenArea.add(totalAmount, 0, 4);
        mainScreenArea.add(cashButton, 0, 5);
        mainScreenArea.add(visaButton, 0, 5);
        mainScreenArea.add(checkOuButton, 1, 6);
        
        GridPane.setHalignment(cashButton, HPos.LEFT);
        GridPane.setHalignment(visaButton, HPos.RIGHT);
        
	}
	protected static boolean visaTransaction(Customer customer, Order order) {
		// TODO Auto-generated method stub
		return false;
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
		Button saveButton = new Button("Save");
		Button reviewUsButton = new Button("Review us");
		HBox spacer = new HBox();                 
	    HBox.setHgrow(spacer, Priority.ALWAYS);
		toolbar.getItems().addAll(spacer, logOutButton, saveButton, reviewUsButton);
		
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
		        
		        int column = 1;
				Label[] info = new Label[20];

				for(int counter = 0; counter < customer.getCurrentOrder().getDishes().size(); counter++) {
					info[counter].setText(customer.getCurrentOrder().getDishes().get(counter).getName() +
							"\t" + customer.getCurrentOrder().getDishes().get(counter).getPrice());
					info[counter].setFont(Font.font("Monaco", FontWeight.NORMAL, 10));
					mainScreenArea.add(info[counter], 0, column);
					column++;
				}			
			}
		});

        //makeNewOrderButton
        makeNewOrderButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mainScreenArea.getChildren().clear();
				Label header = new Label("Reserve a table");
				header.setFont(Font.font("Arial", FontWeight.BOLD, 20));
				
				DatePicker datePicker = new DatePicker();
				
				ComboBox<Table> availableTables = new ComboBox<>(restaurant.retrieveAvailableTables());
				availableTables.setPromptText("Check available tables");
				Label message = new Label();
				Label dateLbl = new Label("Select date:");
				Label timeLbl = new Label("Select time: ");
				TextField hourTxt = new TextField();
				hourTxt.setPrefWidth(100);
				hourTxt.setMaxWidth(100);
				hourTxt.setPromptText("hour");
				Label colonLbl = new Label(" : ");
				TextField minTxt = new TextField();
				minTxt.setPrefWidth(100);
				minTxt.setMaxWidth(100);
				minTxt.setPromptText("minute");
				Button selectButton = new Button("Select");
				mainScreenArea.add(header, 0, 0);
				mainScreenArea.add(availableTables, 1, 1);
				mainScreenArea.add(datePicker, 1, 2);
				mainScreenArea.add(dateLbl, 0, 2);
				mainScreenArea.add(timeLbl, 0, 3);
				mainScreenArea.add(hourTxt, 1, 3);
				mainScreenArea.add(colonLbl, 1, 3);
				mainScreenArea.add(minTxt, 1, 3);
				mainScreenArea.add(message, 0, 4);
				mainScreenArea.add(selectButton, 2, 5);
				
				GridPane.setHalignment(hourTxt, HPos.LEFT);
				GridPane.setHalignment(colonLbl, HPos.CENTER);
				GridPane.setHalignment(minTxt, HPos.RIGHT);
				
				Order order = new Order();
				if (restaurant.retrieveAvailableTables() == null) {
					message.setText("We're sorry.\nThere were no available tables at this time\nPlease try again later");
					message.setTextFill(Color.web("#ff0000", 0.8));
				}
				else {
				
				selectButton.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						//TODO: add to customer's order this table
						Time time = new Time(Integer.parseInt(hourTxt.getText()),Integer.parseInt(minTxt.getText().toString()));
						if(availableTables.getValue() != null && time.getHour() != 0 && time.getMinute() != 0 && datePicker.getValue() != null) {
							
							order.setDate(datePicker.getValue());
							order.setTime(time);
							order.setTable(availableTables.getValue());
							order.getTable().setAvailable(false);
							//TODO: redirect to selecting dishes
							viewCustomerMenu(order, mainScreenArea, restaurant, customer);
							
							//TODO: redirect to selecting dishes
							
						} else {
							message.setText("Please fill in all information correctly");
							message.setTextFill(Color.web("#ff0000", 0.8));
						}
						

						
						
						
					}
				});
				
				}
				
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
						restaurant.getReviews().getReviews().add(comment.getText());
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
		Button saveButton = new Button("Save");
		HBox spacer = new HBox();                 
	    HBox.setHgrow(spacer, Priority.ALWAYS);
		toolbar.getItems().addAll(spacer, saveButton, logOutButton);
		
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
		Button saveButton = new Button("Save");
		HBox spacer = new HBox();                 
	    HBox.setHgrow(spacer, Priority.ALWAYS);
		toolbar.getItems().addAll(spacer, saveButton, logOutButton);
		
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
		Button saveButton = new Button("Save");
		HBox spacer = new HBox();                 
	    HBox.setHgrow(spacer, Priority.ALWAYS);
		toolbar.getItems().addAll(spacer, saveButton, logOutButton);
		
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
