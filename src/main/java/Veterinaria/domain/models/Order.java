package Veterinaria.domain.models;

public class Order {
    private long orderID;
    private Pet pet;
    private Person owner;
    private User veterinarian;
    private ClinicalRecord clinicalRecord;
    private String date;
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public Pet getPet() {
		return pet;
	}
	public void setPet(Pet pet) {
		this.pet = pet;
	}
	public Person getOwner() {
		return owner;
	}
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	public User getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(User veterinarian) {
		this.veterinarian = veterinarian;
	}
	public ClinicalRecord getClinicalRecord() {
		return clinicalRecord;
	}
	public void setClinicalRecord(ClinicalRecord clinicalRecord) {
		this.clinicalRecord = clinicalRecord;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
    
    
}//cambio private ClininalRcord orderID por long orderID
