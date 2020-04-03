package restaurant.food;

public class MainCourse extends Dish {
	public MainCourse(String name, double price) {
		super(name, price);
	}

	{
		setTax(0.15);
	}

}
