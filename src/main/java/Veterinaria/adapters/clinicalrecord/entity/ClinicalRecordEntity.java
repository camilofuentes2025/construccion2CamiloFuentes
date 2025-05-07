package Veterinaria.adapters.clinicalrecord.entity;

import Veterinaria.adapters.orders.entity.OrderEntity;
import Veterinaria.adapters.pets.entity.PetEntity;
import Veterinaria.adapters.users.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "clinicalrecord")
@Getter
@Setter
@NoArgsConstructor
public class ClinicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "historyID")
    private long historyID;

    @Column(name = "date")
    private Date date;

    @OneToOne
    @JoinColumn(name = "veterinarian_id")
    private UserEntity user;

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

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @Column(name = "vaccination_history")
    private String vaccinationHistory;

    @Column(name = "allergy_medications")
    private String allergyMedications;

    @Column(name = "procedure_details")
    private String procedureDetails;

    @Column(name = "order_canceled")
    private boolean orderCanceled;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

	public long getHistoryID() {
		return historyID;
	}

	public void setHistoryID(long historyID) {
		this.historyID = historyID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
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

	public PetEntity getPet() {
		return pet;
	}

	public void setPet(PetEntity pet) {
		this.pet = pet;
	}
    
    
}