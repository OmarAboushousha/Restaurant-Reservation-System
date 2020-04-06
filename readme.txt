Restaurant Reservation System
This program simulates a real-life restaurant application where different users can log in. 
Assumptions made: 
	Menu is loaded from an xml file. There are 4 types of dishes: appetizers, main course, desserts, and
	drinks. Drinks are not in the original xml file, but if added, the program will be able to handle 
	them.
	
	The application is not time constrained i.e. customers who make reservations are assumed to have not
	arrived yet. The program does not handle customers actually arriving at the restaurant.

	The customer visa card is not loaded automatically. The user has to manually input the card number,
	the card PIN code, and even the balance, as the program has no way of accessing any bank accounts.

	User must save all changes manually except for signing up a new user.

The program can: 
	Add new users through the sign up button on the logscreen. Customers may sign up freely, but each 
	type of staff has to use their own code to sign up, to avoid anyone accessing the system.

	Reject usernames that are duplicates of already-existing usernames.
	
	Show user's profile including their name, their username, their password (which is not actually shown,
	but is hidden by asterisks).

	Add visa card information for customer.
	
	Let customer see their latest order reserved through the system.

	Let customer make a new reservation, choosing the table, the date and time, the dishes to be added, 
	and whether they wish to pay by cash or visa (if by visa, the credentials must first be input manually).

	Let customer leave an anonymous review for the manager to see.

	Let manager access all information about reservations, and check total money earned by the restaurant, 
	as well as check reviews.

	Let cook see the reservations' table number and ordered dishes.

	Let waiter see the reservations' table number and customer name.

	Let user log out of the system.

Division of labour:
	Zoom meetings: 
		UML was drawn during the first zoom meeting where main actor classes were established. 
		The helper classes - which have to do with XML file handling - were omitted from the
		UML class diagram.

		Loading the XML file by unmarshalling it.

	Omar Aboushousha ID.6492
		Manager dashboard, including viewing statistics and viewing the reservations.
		
		Cook dashboard, including viewing the reservations.

		Waiter dashboard, including viewing the reservations.  
		
		As well as view order functionality in the customer dashboard.

	Heba Elwazzan ID.6521
		The rest of the customer dashboard.

		The login and sign up screens, and the log out function.

		The show profile function.

		The basic layout of the dashboard, GUI-wise.

		Saving the XML file by unmarshalling it.
		