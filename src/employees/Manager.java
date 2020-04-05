package employees;

import restaurant.Order;
import restaurant.food.Dish;

public class Manager extends Employee {
	
	private static final String managerCode = "manager_code"; 

	public static String getManagerCode() {
		return managerCode;
	}

	public Manager(String name, String username, String password) {
		super(name, username, password);
	}

	/*public Dish[] viewMenu()
	{
		return menu;
	}*/
	
	public Manager() {
		// TODO Auto-generated constructor stub
	}

	public void editDishPrice(Dish dish)
	{
		//TODO: allows manager to access dishes' prices and change them
	}
	
	/*public restaurantDay viewRestaurantDay()
	{
		return day;
	}*/

	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Manager";
	}
}
