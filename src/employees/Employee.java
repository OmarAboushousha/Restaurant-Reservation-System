package employees;

import restaurant.Order;
import restaurantReservationSystem.Person;

public abstract class Employee extends Person {
	public Employee(String name, String username, String password) {
		super(name, username, password);
	}
	
	public Employee() {
	super();
}
	
	//There was no time to implement these sorry
	
//	private float salary;
//	private int daysOff;
//	
//	
//

//
//	public float getSalary() {
//		return salary;
//	}
//
//
//
//	public void setSalary(float salary) {
//		this.salary = salary;
//	}
//
//
//
//	public int getDaysOff() {
//		return daysOff;
//	}
//
//
//
//	public void setDaysOff(int daysOff) {
//		this.daysOff = daysOff;
//	}
//
//
//
//	public abstract Order seeOrder(int orderNumber);

}


