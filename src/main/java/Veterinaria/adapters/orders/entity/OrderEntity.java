package Veterinaria.adapters.orders.entity;

import java.sql.Date;

import Veterinaria.adapters.persons.entity.PersonEntity;
import Veterinaria.adapters.pets.entity.PetEntity;
import Veterinaria.adapters.users.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")

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
    private String clinicalRecord;

    @Column(name = "date")
    private Date date; 

	public long getOrderID() {
		return orderID;
	}

	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}

	public PetEntity getPet() {
		return pet;
	}

	public void setPet(PetEntity pet) {
		this.pet = pet;
	}

	public PersonEntity getPetOwner() {
		return petOwner;
	}

	public void setPetOwner(PersonEntity petOwner) {
		this.petOwner = petOwner;
	}

	public UserEntity getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(UserEntity veterinarian) {
		this.veterinarian = veterinarian;
	}

	public String getClinicalRecord() {
		return clinicalRecord;
	}

	public void setClinicalRecord(String clinicalRecord) {
		this.clinicalRecord = clinicalRecord;
	}

	public Date getDate() {
        return date; 
    }

    public void setDate(Date date) {
        this.date = date; 
    }
    }


