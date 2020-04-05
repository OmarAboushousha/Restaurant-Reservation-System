package employees;

import restaurant.Order;

public class Waiter extends Employee {
	
	private static final String waiterCode = "waiter_code";
	

	public static String getWaiterCode() {
		return waiterCode;
	}

	public Waiter(String name, String username, String password) {
		super(name, username, password);
	}
	
	public Waiter() {
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Waiter";
	}
}
