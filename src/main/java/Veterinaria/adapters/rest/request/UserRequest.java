package Veterinaria.adapters.rest.request;

public class UserRequest {
	
	private long id;
    private String name;
    private String role;
	private String username;
    private String password;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", name=" + name + ", age=" + ", role=" + role + ", username=" + username
				+ ", password=" + password + "]";
	}

    
 
	
}
