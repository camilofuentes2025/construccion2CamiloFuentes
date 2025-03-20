package Veterinaria.adapters.clinicalrecord.entity;

import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.users.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clinical_record")
@Setter
@Getter
@NoArgsConstructor
public class ClinicalRecordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historyID")
    private long historyID;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "veterinarianID")
    private UserEntity veterinarian;

    @Column(name = "consultation_reason")
    private String consultationReason;

    @Column(name = "symptoms")
    private String symptoms;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "procedure")
    private String procedure;

    @Column(name = "medication")
    private String medication;

    @Column(name = "dosage")
    private String dosage;

    @Column(name = "orderID")
    private OrderEntity orderID;

    @Column(name = "vaccination_history")
    private String vaccinationHistory;

    @Column(name = "allergy_medications")
    private String allergyMedications;

    @Column(name = "procedure_details")
    private String procedureDetails;

    @Column(name = "order_canceled")
    private boolean orderCanceled;

	public long getHistoryID() {
		return historyID;
	}

	public void setHistoryID(long historyID) {
		this.historyID = historyID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public UserEntity getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(UserEntity veterinarian) {
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

	public OrderEntity getOrderID() {
		return orderID;
	}

	public void setOrderID(OrderEntity orderID) {
		this.orderID = orderID;
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
    
    
}
