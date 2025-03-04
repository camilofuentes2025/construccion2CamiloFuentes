package Veterinaria.ports;



import Veterinaria.domain.models.Pet;

public interface PetPort {
    Pet findByPetID(long petID);
    void save(Pet pet);
    void delete(Pet pet);
}

