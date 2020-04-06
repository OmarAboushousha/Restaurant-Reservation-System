package customers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import restaurant.Order;
import restaurantReservationSystem.Person;

@XmlRootElement(name = "customer") 
@XmlAccessorType(XmlAccessType.NONE)
public class Customer extends Person {

	@XmlElement(name = "balance")
	private double balance;

	@XmlElement(name = "visaCardNum")
	private String visaCardNumber;

	@XmlElement(name = "visaCardPin")
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
		return "Customer";
	}

	public void calculateBalance(double price) {
		balance -= price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((currentOrder == null) ? 0 : currentOrder.hashCode());
		result = prime * result + ((visaCardNumber == null) ? 0 : visaCardNumber.hashCode());
		result = prime * result + ((visaCardPinCode == null) ? 0 : visaCardPinCode.hashCode());
		return result;
	}





}



