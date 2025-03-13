package Veterinaria.adapters.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.adapters.pets.entity.PetEntity;
import Veterinaria.adapters.pets.repository.PetRepository;
import Veterinaria.domain.models.Pet;
import Veterinaria.ports.PetPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class PetAdapter implements PetPort {
    @Autowired
    private PetRepository petRepository;

    @Override
    public boolean existPet(long petID) {
        return petRepository.existsByPetID(petID);
    }

    @Override
    public void savePet(Pet pet) {
        PetEntity petEntity = convertToPetEntity(pet);
        petRepository.save(petEntity);
        pet.setPetID(petEntity.getPetID());
    }

    @Override
    public Pet findBypetId(long petID) {
        PetEntity petEntity = petRepository.findByPetID(petID).orElse(null);
        return convertToPet(petEntity);
    }

    private Pet convertToPet(PetEntity petEntity) {
        if (petEntity == null) return null;

        Pet pet = new Pet();
        pet.setPetName(petEntity.getPetName());
        pet.setOwner(new Person()); // Debes obtener la entidad Person
        pet.setAge(petEntity.getAge());
        pet.setPetID(petEntity.getPetID());
        pet.setAnimalSpecies(petEntity.getAnimalSpecies());
        pet.setAnimalBreed(petEntity.getAnimalBreed());
        pet.setCharacteristics(petEntity.getCharacteristics());
        pet.setWeight(petEntity.getWeight());
        return pet;
    }

    private PetEntity convertToPetEntity(Pet pet) {
        PetEntity petEntity = new PetEntity();
        petEntity.setPetName(pet.getPetName());
        petEntity.setOwner(pet.getOwner().getName()); // Ajustar según tu lógica
        petEntity.setAge(pet.getAge());
        petEntity.setPetID(pet.getPetID());
        petEntity.setAnimalSpecies(pet.getAnimalSpecies());
        petEntity.setAnimalBreed(pet.getAnimalBreed());
        petEntity.setCharacteristics(pet.getCharacteristics());
        petEntity.setWeight(pet.getWeight());
        return petEntity;
    }
}
