package restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import customers.Customer;
import restaurant.food.Dish;
import restaurant.table.Table;
import restaurantReservationSystem.Time;

public class Order {
	
	private Table table;
	private List<Dish> dishes = new ArrayList<>();
	private Customer customer;
	private float price;
<<<<<<< HEAD
	private LocalDate date;
	private  Time time;
=======
	private Date date;
	private Time time;
>>>>>>> 7311d950914a41105a1adb07b2ee67d06e253b07
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
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
	
	public double calculatePrice()
	{
		double price = 0;
		for (int i = 0; i < dishes.size(); i++) {
			price += dishes.get(i).getPrice() * (1- dishes.get(i).getTax());
		}
		return price;
	}
	
}
