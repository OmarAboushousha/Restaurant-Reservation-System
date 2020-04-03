package employees;

import restaurant.Order;
import restaurant.food.Dish;

public class Manager extends Employee {

	public Dish[] viewMenu()
	{
		return menu;
	}
	
	public void editDishPrice(Dish dish)
	{
		//TODO: allows manager to access dishes' prices and change them
	}
	
	public restaurantDay viewRestaurantDay()
	{
		return day;
	}

	@Override
	public Order seeOrder(int orderNumber) {
		// TODO: Manager is allowed to view full details of orders today
		return null;
	}
}
