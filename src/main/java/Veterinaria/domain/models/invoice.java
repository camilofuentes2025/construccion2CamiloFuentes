package Veterinaria.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class invoice {
	
	private long invoiceID;
	private Pet petID;
	private Person petOwnerID;
	private ClinicalRecord clinicalRecordID;
	private ClinicalRecord medicineName;
	private int price;
	private boolean amount;
	private String date;
	
	

}
