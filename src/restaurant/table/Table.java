package restaurantReservationSystem;

public abstract class Table {

	private Order currentOrder;
	private int numberOfSeats;
	private int tableNumber;
	private boolean available;
	
	public void reserveTable()
	{
		if(!available)
			System.out.println("Table not available.");
		else
		{
			
		}
	}
	
}
