package restaurantReservationSystem;

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

	public void login(String usernameInput, String passwordInput)
	{
		while(!usernameInput.equals(username)
				&& !passwordInput.equals(password))
		{
			//output to be changed from console to screen after adding gui
			System.out.println("INVALID INPUT.\n"
					+ "Enter the correct username and password.");
		}
		
		//change window appearance to dashboard depending on user using gui
	}
	
	public void logout()
	{
		//change window appearance back to login screen using gui
	}

}
