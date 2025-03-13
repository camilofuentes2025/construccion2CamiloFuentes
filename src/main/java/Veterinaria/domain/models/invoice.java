package Veterinaria.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


public class invoice {
	
	private long invoiceID;
	private Pet pet;
	private Person owner;
	private ClinicalRecord order;
	private ClinicalRecord medicine;
	private int price;
	private long amount;
	private String date;
	
	

}
