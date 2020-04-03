package customers;

import restaurantReservationSystem.Date;

public class PremiumCustomer extends Customer {
	
	public PremiumCustomer(String name, String username, String password) {
		super(name, username, password);
		// TODO Auto-generated constructor stub
	}
	private double discount = 0.1;
	private Date expirationDate;

}
