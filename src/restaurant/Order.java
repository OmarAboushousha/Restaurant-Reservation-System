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
	
	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public List<Dish> getDishes() {
		return dishes;
	}

	public void setDishes(List<Dish> dishes) {
		this.dishes = dishes;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

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
