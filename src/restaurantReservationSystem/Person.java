package restaurantReservationSystem;

public abstract class Person {
	
	private String name;
	private String username;
	private String password;
	
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
