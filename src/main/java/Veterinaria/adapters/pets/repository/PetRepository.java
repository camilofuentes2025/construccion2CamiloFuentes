package Veterinaria.adapters.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import Veterinaria.adapters.pets.entity.PetEntity;

public interface PetRepository extends JpaRepository<PetEntity, Long> {
    boolean existsByPetID(long petID);
    PetEntity findByPetID(long petID);
}
