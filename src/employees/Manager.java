package employees;

public class Manager extends Employee {

	private static final String managerCode = "manager_code"; 

	public static String getManagerCode() {
		return managerCode;
	}

	public Manager(String name, String username, String password) {
		super(name, username, password);
	}

	public Manager() {

	}

	@Override
	public String toString() {
		return "Manager";
	}
}
