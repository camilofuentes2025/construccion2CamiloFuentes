package Veterinaria.adapters.invoices.entity;

import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.persons.entity.PersonEntity;
import Veterinaria.adapters.pets.entity.PetEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "invoice")
@Getter
@Setter
@NoArgsConstructor
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoiceID")
    private long invoiceID;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private PersonEntity owner;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(name = "medicine")
    private String medicine;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private long amount;

    @Column(name = "date")
    private Date date;

	public long getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(long invoiceID) {
		this.invoiceID = invoiceID;
	}

	public PetEntity getPet() {
		return pet;
	}

	public void setPet(PetEntity pet) {
		this.pet = pet;
	}

	public PersonEntity getPerson() {
		return owner;
	}

	public void setPerson(PersonEntity person) {
		this.owner = person;
	}

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getAmount() {
		return amount;
	}

	public void setAmount(long amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
    
    
}