package restaurantReservationSystem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Time")
@XmlAccessorType(XmlAccessType.FIELD)
public class Time {
	public Time() {
	}

	@XmlElement(name = "hour")
	private int hour;

	@XmlElement(name = "minute")
	private int minute;

	public Time(int hour, int minute) {
		setHour(hour);
		setMinute(minute);
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
	
	@Override
	public String toString() {
		return hour + ":" + minute;
	}

}
