package Veterinaria.adapters.clinicalrecord.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clinical_record")
@Getter
@Setter
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
    private long orderID;

    @Column(name = "vaccination_history")
    private String vaccinationHistory;

    @Column(name = "allergy_medications")
    private String allergyMedications;

    @Column(name = "procedure_details")
    private String procedureDetails;

    @Column(name = "order_canceled")
    private boolean orderCanceled;  
}
