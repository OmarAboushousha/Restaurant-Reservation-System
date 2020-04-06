package employees;

public class Cook extends Employee {
	
	private static final String cookCode = "cook_code";
	
	public static String getCookCode() {
		return cookCode;
	}

	public Cook(String name, String username, String password) {
		super(name, username, password);
	}
	
	public Cook() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "Cook";
	}
}
