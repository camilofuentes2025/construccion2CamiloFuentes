package Veterinaria.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Pet {
	
	private String petName;
	private Person owner;
	private long age;
	private long petID;
	private String animalSpecies;
	private String animalBreed;
	private String characteristics;
	private long weight;
	

}
