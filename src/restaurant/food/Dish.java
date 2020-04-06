package restaurant.food;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dish")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dish {

	@XmlElement(name = "name")
	private String name;

	@XmlElement(name = "price")
	private double price;

	@XmlElement(name = "tax")
	private double tax;

	public Dish() {
		super();
	}

	public Dish(String name, double price) {
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double d) {
		this.tax = d;
	}

	@Override
	public String toString() {

		return name + "  " + price + " L.E" + "\n";

	}
}
