package restaurant.food;

public class Dessert extends Dish {
	public Dessert(String name, double price) {
		super(name, price);
	}

	{
		setTax(0.2);
	}

}
