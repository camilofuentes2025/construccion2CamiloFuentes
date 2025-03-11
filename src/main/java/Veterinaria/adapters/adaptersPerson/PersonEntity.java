package Veterinaria.adapters.adaptersPerson;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "persons")
@Getter
@Setter
@NoArgsConstructor
public class PersonEntity{
	@Id
    @Column(name = "Id")
	private long Id;
    @Column(name = "name")
	private String name;
    @Column(name = "age")
	private long age;
    @Column(name = "role")
	private String role;

}
