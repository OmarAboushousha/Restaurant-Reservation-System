package restaurant.food;

public abstract class Dish {
	
	private String name;
	private double price;
	private double tax;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
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
	
	

}
