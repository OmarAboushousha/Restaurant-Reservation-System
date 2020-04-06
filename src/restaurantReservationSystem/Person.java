package restaurantReservationSystem;

import xmlHandlers.Restaurant;

public abstract class Person {

	private String name;
	private String username;
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Person(String name, String username, String password) {
		this.name = name;
		this.username = username;
		this.password = password;
	}

	public Person() {
		super();
	}

	public static int login(String usernameInput, String passwordInput, Restaurant restaurant)
	{
		for(int i = 0; i < restaurant.getPersons().size(); i++)
		{
			if(restaurant.getPersons().get(i).username.equals(usernameInput) 
					&& restaurant.getPersons().get(i).password.equals(passwordInput))
				return i;
		}
		return -1;
	}

}
