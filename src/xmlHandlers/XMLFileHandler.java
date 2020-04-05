package xmlHandlers;

import java.io.File;
import java.util.ArrayList;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import customers.Customer;
import employees.Cook;
import employees.Manager;
import employees.Waiter;
import gui.Main;
import restaurant.food.Drinks;
import restaurant.food.MainCourse;
import restaurantReservationSystem.Person;
import restaurant.food.Appetizers;
import restaurant.food.Dessert;
import restaurant.food.Dish;

public class XMLFileHandler {

	public static Restaurant LoadFile(String filename) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);

		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		Restaurant restaurant = (Restaurant) unmarshaller.unmarshal(new File(filename));

		restaurant.persons = new ArrayList<>();

		for (User user: restaurant.getUsers().getUsers()) {
			if (user.getRole().equals("Manager"))
				restaurant.persons.add(new Manager(user.getName(), user.getUsername(),
						user.getPassword()));

			else if (user.getRole().equals("Cooker"))
				restaurant.persons.add(new Cook(user.getName(), user.getUsername(),
						user.getPassword()));

			else if (user.getRole().equals("Waiter"))
				restaurant.persons.add(new Waiter(user.getName(), user.getUsername(),
						user.getPassword()));

			else if (user.getRole().equals("Client"))
				restaurant.persons.add(new Customer(user.getName(), user.getUsername(),
						user.getPassword(), user.getBalance(), user.getVisaCardNumber(),
						user.getVisaCardPinCode(), user.getOrder()));
		}


		restaurant.menu = new ArrayList<Dish>();
		for (DishX dishX: restaurant.getDishes().getDishes()) {
			if (dishX.getType().contentEquals("appetizer"))
				restaurant.menu.add(new Appetizers(dishX.getName(), dishX.getPrice()));
			else if (dishX.getType().contentEquals("main_course"))
				restaurant.menu.add(new MainCourse(dishX.getName(), dishX.getPrice()));
			else if (dishX.getType().contentEquals("desert"))
				restaurant.menu.add(new Dessert(dishX.getName(), dishX.getPrice()));
			else if (dishX.getType().contentEquals("drink"))
				restaurant.menu.add(new Drinks(dishX.getName(), dishX.getPrice()));
		}
		return restaurant;

	}

	public static void saveFile(Restaurant restaurant, String filename) throws JAXBException {

		restaurant.getUsers().getUsers().clear();
		restaurant.getDishes().getDishes().clear();

		for (Person person: restaurant.getPersons()) {
			String role;
			if (person instanceof Customer) {
				role = "Client";
				Customer customer = (Customer) person;
				restaurant.getUsers().getUsers().add(new User(customer.getName(), customer.getUsername(), customer.getPassword(), 
						role, customer.getBalance(), customer.getCurrentOrder(), customer.getVisaCardNumber(), customer.getVisaCardPinCode()));

			} else {
				if (person instanceof Manager) {
					role = "Manager";

				} else if (person instanceof Cook) {
					role = "Cooker";

				} else {
					role = "Waiter";
				}
				restaurant.getUsers().getUsers().add(new User(person.getName(), person.getUsername(), 
						person.getPassword(), role));
			}

		}

		for (Dish dish: restaurant.getMenu()) {
			String type;
			if (dish instanceof Appetizers) {
				type = "appetizer";

			} else if (dish instanceof MainCourse) {
				type = "main_course";
			} else if (dish instanceof Dessert) {
				type = "desert";
			} else {
				type = "drink";
			}
			restaurant.getDishes().getDishes().add(new DishX(dish.getName(), dish.getPrice(), type));
		}

		JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		marshaller.marshal(restaurant, new File(filename));

	}
}
