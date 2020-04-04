package restaurant;

import java.util.ArrayList;
import java.util.List;

import customers.Customer;
import restaurant.food.Dish;
import restaurant.table.Table;
import restaurantReservationSystem.Date;
import restaurantReservationSystem.Time;

public class Order {
	
	private Table table;
	private List<Dish> dishes = new ArrayList<>();
	private Customer customer;
	private float price;
	private Date date;
	private  Time time;
	private boolean paid;
	private int orderNumber;
	
	public Order reserve()
	{
		Order order = new Order();
		return order;
	}
	
	/*public float addCoupon(String couponCode)
	{
		
	}*/
	
	public float calculatePrice()
	{
		return price;
	}
	
}
