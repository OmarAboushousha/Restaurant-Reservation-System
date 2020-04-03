package employees;

import restaurant.Order;
import restaurant.food.Dish;

public class Cook extends Employee {
	
	public Dish[] viewMenu()
	{
		return menu;
	}

	public void editMenu(Dish[] dishes)
	{
		//TODO: offers user option to alter the menu by removing or adding dishes
	}

	@Override
	public Order seeOrder(int orderNumber) {
		// TODO: cook is not allowed to see customer's name or price of order
		return null;
	}
}
