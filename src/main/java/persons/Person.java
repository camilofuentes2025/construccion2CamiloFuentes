package persons;

public class Person {
	
	private long cedula;
	private String name;
	private long age;
	private String role;
	
	public Person(long cedula, String name, long age, String role) {

		super();
		this.cedula = cedula;
		this.name = name;
		this.age = age;
		this.role = role;
	}
	
	public long getCedula() {
		return cedula;
	}
	
	public void setCedula(long cedula) {
		this.cedula = cedula;
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
	
}
