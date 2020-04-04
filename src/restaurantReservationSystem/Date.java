package restaurantReservationSystem;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if (day> 0 && day < 32)
			this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if (month > 0 && month < 13)
			this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if (year > 1980 && year < 2021)
		this.year = year;
	}
	
	

}
