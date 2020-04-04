package restaurant.table;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import restaurant.Order;

@XmlRootElement(name = "table")
@XmlAccessorType(XmlAccessType.FIELD)
public class Table {

	private Order currentOrder;
	
	@XmlElement(name = "number_of_seats")
	private int numberOfSeats;
	
	@XmlElement(name = "number")
	private int tableNumber;
	
	@XmlElement(name = "smoking")
	private boolean smoking;
	
	@XmlElement(name = "available")
	private boolean available = true;
	
	public Order getCurrentOrder() {
		return currentOrder;
	}

	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void reserveTable()
	{
		
	}
	
	public stat void 
	@Override
	public String toString() {
		if (isSmoking())
			return String.valueOf(tableNumber) + "\t" +  "smoking";
		return String.valueOf(tableNumber) + "\t" +  "non-smoking";
	}
	
}
