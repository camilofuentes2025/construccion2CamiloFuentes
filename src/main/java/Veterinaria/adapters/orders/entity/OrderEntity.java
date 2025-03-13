package Veterinaria.adapters.orders.entity;

import Veterinaria.adapters.persons.entity.PersonEntity;
import Veterinaria.adapters.pets.entity.PetEntity;
import Veterinaria.adapters.users.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderID")
    private long orderID;

    @ManyToOne
    @JoinColumn(name = "petID")
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "petOwnerID")
    private PersonEntity petOwner;

    @ManyToOne
    @JoinColumn(name = "veterinarianID")
    private UserEntity veterinarian;

    @Column(name = "clinicalRecord")
    private String clinicalRecord; // Assuming it's a String, change if needed

    @Column(name = "date")
    private String date;
}
