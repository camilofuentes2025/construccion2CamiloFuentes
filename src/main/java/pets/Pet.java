package pets;

import persons.PetOwner;

public class Pet {
	
	private String petName;
	private PetOwner owner;
	private long age;
	private long petID;
	private String animalSpecies;
	private String animalBreed;
	private String characteristics;
	private long weight;
	
	public Pet(String petName, PetOwner owner, long age, long petID, String animalSpecies, String animalBreed,
			String characteristics, long weight) {
		super();
		this.petName = petName;
		this.owner = owner;
		this.age = age;
		this.petID = petID;
		this.animalSpecies = animalSpecies;
		this.animalBreed = animalBreed;
		this.characteristics = characteristics;
		this.weight = weight;
	}

	
	public String getPetName() {
		return petName;
	}

	
	public void setPetName(String petName) {
		this.petName = petName;
	}

	
	public PetOwner getOwner() {
		return owner;
	}

	
	public void setOwner(PetOwner owner) {
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
	
}
