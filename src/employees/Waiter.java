package employees;

import restaurant.Order;

public class Waiter extends Employee {

	public Waiter(String name, String username, String password) {
		super(name, username, password);
	}
	
	@Override
	public Order seeOrder(int orderNumber) {
		// TODO: waiter is not allowed to see order's price
		return null;
	}

}
