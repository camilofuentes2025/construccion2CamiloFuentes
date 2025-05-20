package Veterinaria.adapters.rest.request;

import Veterinaria.domain.models.Person;

public class PetRequest {
	
	private String petName;
	private Person owner;
	private long age;
	private long petID;
	private String animalSpecies;
	private String animalBreed;
	private String characteristics;
	private long weight;
	public String getPetName() {
		return petName;
	}
	public void setPetName(String petName) {
		this.petName = petName;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public long getPetID() {
		return petID;
	}
	public void setPetID(long petID) {
		this.petID = petID;
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
	@Override
	public String toString() {
		return "PetRequest [petName=" + petName + ", owner=" + owner + ", age=" + age + ", petID=" + petID
				+ ", animalSpecies=" + animalSpecies + ", animalBreed=" + animalBreed + ", characteristics="
				+ characteristics + ", weight=" + weight + "]";
	}
	
	

}
