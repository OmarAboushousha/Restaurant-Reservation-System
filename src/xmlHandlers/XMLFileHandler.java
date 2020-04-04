package xmlHandlers;

import java.io.File;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import customers.Customer;
import employees.Cook;
import employees.Manager;
import employees.Waiter;
import gui.Main;
import restaurant.food.Drinks;
import restaurant.food.MainCourse;
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
}
