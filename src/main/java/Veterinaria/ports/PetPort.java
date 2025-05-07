package Veterinaria.ports;

import Veterinaria.domain.models.Pet;

public interface PetPort {
	
	public boolean existPet(long petID);
	public void savePet(Pet pet);
    public Pet findByPetID(long petID);
}
