package restaurant.food;

public class Drinks extends Dish {
	public Drinks(String name, double price) {
		super(name, price);
	}

	{
		setTax(0.05);
	}

}
