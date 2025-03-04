package Veterinaria.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {
	
	private long cedula;
	private String name;
	private long age;
	private String role;
}
