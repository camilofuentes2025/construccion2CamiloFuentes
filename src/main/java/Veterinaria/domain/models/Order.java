package Veterinaria.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
	
	private ClinicalRecord OrdenID;
	private Pet petID;
	private long petOwnerID;
	private User veterinarianID;
	private ClinicalRecord medicine;
	private String date;
	
	
}
