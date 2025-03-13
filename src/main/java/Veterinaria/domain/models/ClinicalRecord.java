package Veterinaria.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClinicalRecord {
    private String date;              
    private User veterinarian;        
    private String consultationReason; 
    private String symptoms;          
    private String diagnosis;         
    private String procedure;        
    private String medication;        
    private String dosage;            
    private long orderID;             
    private String vaccinationHistory; 
    private String allergyMedications; 
    private String procedureDetails;  
    private boolean orderCanceled;    
}
