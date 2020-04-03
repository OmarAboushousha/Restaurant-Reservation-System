package xmlHandlers;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import restaurant.food.Dish;
@XmlRootElement(name = "dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dishes {
	
	@XmlElement(name = "dish")
	List<DishUnmodified> dishUnmodified;

	public List<DishUnmodified> getDishUnmodified() {
		return dishUnmodified;
	}

	public void setDishUnmodified(List<DishUnmodified> menu) {
		this.dishUnmodified = menu;
	}

}
