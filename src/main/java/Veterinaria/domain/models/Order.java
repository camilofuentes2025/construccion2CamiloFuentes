package Veterinaria.domain.models;


public class Order {
	
	private ClinicalRecord OrdenID;
	private Pet petID;
	private PetOwner petOwnerID;
	private User veterinarianID;
	private ClinicalRecord medicine;
	private String date;
	
	public Order(ClinicalRecord ordenID, Pet petID, PetOwner petOwnerID, User veterinarianID,
			ClinicalRecord medicine, String date) {
		super();
		OrdenID = ordenID;
		this.petID = petID;
		this.petOwnerID = petOwnerID;
		this.veterinarianID = veterinarianID;
		this.medicine = medicine;
		this.date = date;
	}
	public ClinicalRecord getOrdenID() {
		return OrdenID;
	}
	public void setOrdenID(ClinicalRecord ordenID) {
		OrdenID = ordenID;
	}
	public Pet getPetID() {
		return petID;
	}
	public void setPetID(Pet petID) {
		this.petID = petID;
	}
	public PetOwner getPetOwnerID() {
		return petOwnerID;
	}
	public void setPetOwnerID(PetOwner petOwnerID) {
		this.petOwnerID = petOwnerID;
	}
	public User getVeterinarianID() {
		return veterinarianID;
	}
	public void setVeterinarianID(User veterinarianID) {
		this.veterinarianID = veterinarianID;
	}
	public ClinicalRecord getMedicine() {
		return medicine;
	}
	public void setMedicine(ClinicalRecord medicine) {
		this.medicine = medicine;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
    
}
