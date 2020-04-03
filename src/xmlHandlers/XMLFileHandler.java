package xmlHandlers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import customers.Customer;
import employees.Cook;
import employees.Manager;
import employees.Waiter;
import restaurant.food.Drinks;
import restaurant.food.MainCourse;
import restaurant.food.Appetizers;
import restaurant.food.Dessert;

public class XMLFileHandler {

	public static Restaurant LoadFile(String filename) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Restaurant.class);
		
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		
		Restaurant restaurant = (Restaurant) unmarshaller.unmarshal(new File(filename));
		
		for (User user: restaurant.getUsers().getUsers()) {
			if (user.getRole().equals("manager"))
				restaurant.persons.add(new Manager(user.getName(), user.getUsername(), user.getPassword()));
			else if (user.getRole().equals("cook"))
				restaurant.persons.add(new Cook(user.getName(), user.getUsername(), user.getPassword())); 
			else if (user.getRole().equals("waiter"))
				restaurant.persons.add(new Waiter(user.getName(), user.getUsername(), user.getPassword()));
			else if (user.getRole().equals("customer"))
				restaurant.persons.add(new Customer(user.getName(), user.getUsername(), user.getPassword()));
		}
		
		DishUnmodified test = restaurant.getDishes().getDishUnmodified().get(0);
		System.out.println(test.getName());

		for(DishUnmodified dishUnmodified: restaurant.getDishes().getDishUnmodified()) {
			if (dishUnmodified.getType().equals("appetizer"))
				restaurant.menu.add(new Appetizers(dishUnmodified.getName(), dishUnmodified.getPrice()));
			else if (dishUnmodified.getType().equals("main_course"))
				restaurant.menu.add(new MainCourse(dishUnmodified.getName(), dishUnmodified.getPrice()));
			else if (dishUnmodified.getType().equals("desert"))
				restaurant.menu.add(new Dessert(dishUnmodified.getName(), dishUnmodified.getPrice()));
			else if (dishUnmodified.getType().equals("drinks"))
				restaurant.menu.add(new Drinks(dishUnmodified.getName(), dishUnmodified.getPrice()));
		}
		return restaurant;
		
	}
}
