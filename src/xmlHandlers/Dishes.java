package xmlHandlers;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "dishes")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dishes {
	
	@XmlElement(name = "dish")
	List<DishX> dishes = new ArrayList<>();

	public List<DishX> getDishes() {
		return dishes;
	}

	public void setDishes(List<DishX> dishes) {
		this.dishes = dishes;
	}
	
	

}
