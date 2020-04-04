package restaurantReservationSystem;

import gui.Main;
import xmlHandlers.Restaurant;
import xmlHandlers.User;

public abstract class Person extends User {
	
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

	public static Person login(String usernameInput, String passwordInput, Restaurant restaurant)
	{
		for(Person person: restaurant.getPersons())
		{
			if(person.username.equals(usernameInput) && person.password.equals(passwordInput))
				return person;
		}
		return null;
	}
	
	public void logout()
	{
		//change window appearance back to login screen using gui
	}

}
