package restaurant.food;

public abstract class Dish {

	private String name;
	private double price;
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
