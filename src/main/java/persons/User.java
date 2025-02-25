package persons;

public class User extends Person{
	
	private String userName;
	private String password;
	
	public User(long cedula, String name, long age, String role, String userName, String password) {
		super(cedula, name, age, role);
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
