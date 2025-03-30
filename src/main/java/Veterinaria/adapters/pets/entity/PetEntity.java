package Veterinaria.adapters.pets.entity;

import Veterinaria.adapters.persons.entity.PersonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pet")

public class PetEntity {
    @Id
    @Column(name = "petID")
    private long petID;

    @Column(name = "petName")
    private String petName;

    @JoinColumn(name = "owner")
    @OneToOne
    private PersonEntity owner;

    @Column(name = "age")
    private long age;

    @Column(name = "animalSpecies")
    private String animalSpecies;

    @Column(name = "animalBreed")
    private String animalBreed;

    @Column(name = "characteristics")
    private String characteristics;

    @Column(name = "weight")
    private long weight;

	public long getPetID() {
		return petID;
	}

	public void setPetID(long petID) {
		this.petID = petID;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public PersonEntity getOwner() {
		return owner;
	}

	public void setOwner(PersonEntity owner) {
		this.owner = owner;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	public String getAnimalSpecies() {
		return animalSpecies;
	}

	public void setAnimalSpecies(String animalSpecies) {
		this.animalSpecies = animalSpecies;
	}

	public String getAnimalBreed() {
		return animalBreed;
	}

	public void setAnimalBreed(String animalBreed) {
		this.animalBreed = animalBreed;
	}

	public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}
    
    
}
