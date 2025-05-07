package Veterinaria.adapters.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Veterinaria.adapters.pets.entity.PetEntity;
import Veterinaria.adapters.pets.repository.PetRepository;
import Veterinaria.adapters.persons.entity.PersonEntity;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.Person;
import Veterinaria.ports.PetPort;

import java.util.List;
import java.util.stream.Collectors;

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
        if (pet == null || pet.getOwner() == null) {
            throw new IllegalArgumentException("La mascota y el dueño no pueden ser nulos.");
        }
        PetEntity petEntity = convertToPetEntity(pet);
        petRepository.save(petEntity);
        pet.setPetID(petEntity.getPetID());
    }

    @Override
    public Pet findByPetID(long petID) {
        PetEntity petEntity = petRepository.findByPetID(petID);
        return convertToPet(petEntity);
    }

    /*@Override
    public List<Pet> findAllPets() {
        List<PetEntity> petEntities = petRepository.findAll();
        return petEntities.stream()
                .map(this::convertToPet)
                .collect(Collectors.toList());
    }*/

    private Pet convertToPet(PetEntity petEntity) {
        if (petEntity == null) return null;

        Pet pet = new Pet();
        pet.setPetID(petEntity.getPetID());
        pet.setPetName(petEntity.getPetName());
        pet.setAge(petEntity.getAge());
        pet.setOwner(convertToPerson(petEntity.getPerson()));
        pet.setAnimalSpecies(petEntity.getAnimalSpecies());
        pet.setAnimalBreed(petEntity.getAnimalBreed());
        pet.setCharacteristics(petEntity.getCharacteristics());
        pet.setWeight(petEntity.getWeight());
        return pet;
    }

    private PetEntity convertToPetEntity(Pet pet) {
        if (pet == null) return null;

        PetEntity petEntity = new PetEntity();
        petEntity.setPetID(pet.getPetID());
        petEntity.setPetName(pet.getPetName());
        petEntity.setAge(pet.getAge());
        petEntity.setPerson(convertToPersonEntity(pet.getOwner()));
        petEntity.setAnimalSpecies(pet.getAnimalSpecies());
        petEntity.setAnimalBreed(pet.getAnimalBreed());
        petEntity.setCharacteristics(pet.getCharacteristics());
        petEntity.setWeight(pet.getWeight());
        return petEntity;
    }

    private Person convertToPerson(PersonEntity personEntity) {
        if (personEntity == null) return null;

        Person person = new Person();
        person.setId(personEntity.getId());
        person.setName(personEntity.getName());
        person.setAge(personEntity.getAge());
        person.setRole(personEntity.getRole());
        return person;
    }

    private PersonEntity convertToPersonEntity(Person person) {
        if (person == null) return null;

        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(person.getId());
        personEntity.setName(person.getName());
        personEntity.setAge(person.getAge());
        personEntity.setRole(person.getRole());
        return personEntity;
    }
}