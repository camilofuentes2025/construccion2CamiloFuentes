package Veterinaria.domain.models;

import java.sql.Date;


public class ClinicalRecord {
	private long historyID;
	private Date date;
    private User veterinarian;        
    private String consultationReason; 
    private String symptoms;          
    private String diagnosis;         
    private String procedure;        
    private String medication;        
    private String dosage;            
    private Order order;             
    private String vaccinationHistory; 
    private String allergyMedications; 
    private String procedureDetails;  
    private boolean orderCanceled;
	
    
	public long getHistoryID() {
		return historyID;
	}
	public void setHistoryID(long historyID) {
		this.historyID = historyID;
	}
	
	public User getVeterinarian() {
		return veterinarian;
	}
	public void setVeterinarian(User veterinarian) {
		this.veterinarian = veterinarian;
	}
	public String getConsultationReason() {
		return consultationReason;
	}
	public void setConsultationReason(String consultationReason) {
		this.consultationReason = consultationReason;
	}
	public String getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getProcedure() {
		return procedure;
	}
	public void setProcedure(String procedure) {
		this.procedure = procedure;
	}
	public String getMedication() {
		return medication;
	}
	public void setMedication(String medication) {
		this.medication = medication;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public String getVaccinationHistory() {
		return vaccinationHistory;
	}
	public void setVaccinationHistory(String vaccinationHistory) {
		this.vaccinationHistory = vaccinationHistory;
	}
	public String getAllergyMedications() {
		return allergyMedications;
	}
	public void setAllergyMedications(String allergyMedications) {
		this.allergyMedications = allergyMedications;
	}
	public String getProcedureDetails() {
		return procedureDetails;
	}
	public void setProcedureDetails(String procedureDetails) {
		this.procedureDetails = procedureDetails;
	}
	public boolean isOrderCanceled() {
	    return orderCanceled;
	}
	public void setOrderCanceled(boolean orderCanceled) {
	    this.orderCanceled = orderCanceled;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	

	
    
    
}//cambio private long orderID por private Order orderID
