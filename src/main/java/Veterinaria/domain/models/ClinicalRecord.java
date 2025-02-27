package Veterinaria.domain.models;
import java.sql.Date;


public class ClinicalRecord {
	
	private Date createdDate;
	private User whoVeterian;
	private String reason;
	private String symptoms;
	private String diagnostic;
	private String procedure;
	private String medicine;
	private String dosage;
	private long orderID;
	private String vaccinationrecord;
	private String drugAllergies;
	private String procedureDetails;
	private boolean orderCancellation;
	
}
