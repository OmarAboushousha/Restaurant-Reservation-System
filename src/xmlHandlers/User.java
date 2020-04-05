package xmlHandlers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import restaurant.Order;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class User {

	@XmlElement(name = "name")
	private String name;
	
	@XmlElement(name = "username")
	private String username;
	
	@XmlElement(name = "password")
	private String password;
	
	@XmlElement(name = "role")
	private String role;
	
	@XmlElement(name = "balance")
	private double balance;
	
	@XmlElement(name = "order")
	private Order order;
	
	@XmlElement(name = "card_number")
	private String visaCardNumber;
	
	@XmlElement(name = "pin_code")
	private String visaCardPinCode;
	
	public User() {}

	public User(String name, String username, String password, String role, double balance, Order order,
			String visaCardNumber, String visaCardPinCode) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
		this.balance = balance;
		this.order = order;
		this.visaCardNumber = visaCardNumber;
		this.visaCardPinCode = visaCardPinCode;
	}
	
	

	public User(String name, String username, String password, String role) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
}
