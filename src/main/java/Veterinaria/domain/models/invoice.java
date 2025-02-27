package Veterinaria.domain.models;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.PetOwner;
public class invoice {
	
	private long invoiceID;
	private Pet petID;
	private PetOwner petOwnerID;
	private ClinicalRecord clinicalRecordID;
	private ClinicalRecord medicineName;
	private int price;
	private boolean amount;
	private String date;
	
	

}
