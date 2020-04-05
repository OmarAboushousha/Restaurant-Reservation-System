package customers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessorType;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import restaurant.Order;
import restaurant.table.Table;
import restaurantReservationSystem.Person;

public class Customer extends Person {

	private double balance;
	private String visaCardNumber;
	private String visaCardPinCode;
	private Order currentOrder;
	
	public Customer(String name, String username, String password) {
		super(name, username, password);
	}
	
	public Customer(String name, String username, String password, double d, String visaCardNumber,
			String visaCardPinCode, Order currentOrder) {
		super(name, username, password);
		this.balance = d;
		this.visaCardNumber = visaCardNumber;
		this.visaCardPinCode = visaCardPinCode;
		this.currentOrder = currentOrder;
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double d) {
		this.balance = d;
	}

	public String getVisaCardNumber() {
		return visaCardNumber;
	}

	public void setVisaCardNumber(String visaCardNumber) {
		this.visaCardNumber = visaCardNumber;
	}

	public String getVisaCardPinCode() {
		return visaCardPinCode;
	}

	public void setVisaCardPinCode(String visaCardPinCode) {
		this.visaCardPinCode = visaCardPinCode;
	}	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Customer";
	}

	//public void checkOut(Order order) {
		//TODO: code to let user choose method of payment
		//cash: flag this order as unpaid\
		//visa: pay() in visa class and flag this order as paid
		
	}
	
	/*public Table reserveTable() {
	//TODO: code to access table class and find a table corresponding to users needs
	
	
}*/

/*public Order makeOrder(Table chosenTable) {
	//TODO: code to start choosing dishes to add to the order
}*/
	


