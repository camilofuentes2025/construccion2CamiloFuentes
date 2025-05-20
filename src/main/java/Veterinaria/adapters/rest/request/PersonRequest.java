package Veterinaria.adapters.rest.request;

public class PersonRequest {
	
    private long id;
    private String name;
    private long age;
    private String role;
    
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
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;	
    }
	@Override
	public String toString() {
		return "PersonRequest [id=" + id + ", name=" + name + ", age=" + age + ", role=" + role + "]";
	}
}