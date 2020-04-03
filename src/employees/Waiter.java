package employees;

import restaurant.Order;

public class Waiter extends Employee {

	@Override
	public Order seeOrder(int orderNumber) {
		// TODO: waiter is not allowed to see order's price
		return null;
	}

}
