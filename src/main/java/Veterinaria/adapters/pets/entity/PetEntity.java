package Veterinaria.adapters.pets.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pet")
@Getter
@Setter
@NoArgsConstructor
public class PetEntity {
    @Id
    @Column(name = "petID")
    private long petID;

    @Column(name = "petName")
    private String petName;

    @Column(name = "owner")
    private String owner;

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
}
