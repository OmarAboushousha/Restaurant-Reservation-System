package restaurantReservationSystem;

public class Time {
	private int hour;
	private int minute;
	
	public Time(int hour, int minute) {
		setHour(hour);
		setMinute(minute);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return hour + ":" + minute;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		if (hour >= 0 && hour < 24)
			this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		if  (minute >= 0 && minute < 60)
			this.minute = minute;
	}

}
