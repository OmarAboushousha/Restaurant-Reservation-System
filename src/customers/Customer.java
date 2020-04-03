package customers;

import restaurant.Order;
import restaurant.table.Table;
import restaurantReservationSystem.Person;

public class Customer extends Person {

	private float balance;
	private String visaCardNumber;
	private String visaCardPinCode;
	
	public Table reserveTable() {
		//TODO: code to access table class and find a table corresponding to users needs
		
		
	}
	
	public Order makeOrder(Table chosenTable) {
		//TODO: code to start choosing dishes to add to the order
	}
	
	public void checkOut(Order order) {
		//TODO: code to let user choose method of payment
		//cash: flag this order as unpaid\
		//visa: pay() in visa class and flag this order as paid
		
	}
	
}
