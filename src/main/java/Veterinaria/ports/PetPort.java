package Veterinaria.ports;



import Veterinaria.domain.models.Pet;

public interface PetPort {
    public Pet findById(long id);
    public void savePet(Pet pet);
    public void deletePet(Pet pet);
}

