package restaurantReservationSystem;

public class Order {
	
	private Table table;
	private Dish[] dishes;
	private Customer customer;
	private float price;
	private Date date;
	private float time;
	private boolean paid;
	private int orderNumber;
	
	public Order reserve()
	{
		Order order = new Order();
		return order;
	}
	
	public float addCoupon(String couponCode)
	{
		
	}
	
	public float calculatePrice()
	{
		return price;
	}
}