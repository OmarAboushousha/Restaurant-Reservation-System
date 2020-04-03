package restaurant.table;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import restaurant.Order;

@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Table {

	private Order currentOrder;
	
	@XmlElement(name = "number_of_seats")
	private int numberOfSeats;
	
	@XmlElement(name = "number")
	private int tableNumber;
	
	@XmlElement(name = "smoking")
	private boolean smoking;
	
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
