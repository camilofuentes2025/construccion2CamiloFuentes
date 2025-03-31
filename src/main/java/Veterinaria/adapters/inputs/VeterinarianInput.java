package Veterinaria.adapters.inputs;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Veterinaria.adapters.inputs.utils.ClinicalRecordValidator;
import Veterinaria.adapters.inputs.utils.PersonValidator;
import Veterinaria.adapters.inputs.utils.PetValidator;
import Veterinaria.adapters.inputs.utils.UserValidator;
import Veterinaria.adapters.inputs.utils.Utils;
import Veterinaria.ports.ClinicalRecordPort;
import Veterinaria.domain.models.Pet;
import Veterinaria.ports.InputPort;
import Veterinaria.ports.UserPort;
import Veterinaria.domain.models.ClinicalRecord;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.User;
import Veterinaria.domain.models.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@Component
public class VeterinarianInput implements InputPort{
	
	@Autowired
    private ClinicalRecordPort clinicalRecordPort;
    @Autowired
    private ClinicalRecordValidator clinicalRecordValidator;
    @Autowired
    private Date date;
    @Autowired
    private PetValidator petValidator;
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserPort userPort;
    private final String MENU = "Ingrese la opción:"
            + "\n 1. Consultar historia clínica de una mascota."
            + "\n 2. Registrar nueva historia clínica."
            + "\n 3. Crear una orden médica."
            + "\n 4. Anular una orden médica."
            + "\n 5. Salir.";

    public void menu() {
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
        switch (option) {
            case "1": {
                try {
                    this.viewClinicalRecord();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "2": {
                try {
                    this.registerClinicalRecord();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "3": {
                try {
                    this.createMedicalOrder();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "4": {
                try {
                    this.cancelMedicalOrder();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "5": {
                System.out.println("Hasta una próxima ocasión.");
                return;
            }
            default: {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void viewClinicalRecord() throws Exception {
        /*System.out.println("Ingrese el ID de la mascota:");
        long petID = petValidator.petIDValidator(Utils.getReader().nextLine());
        ClinicalRecord record = clinicalRecordPort.findByHistoryID(petID);
        if (record == null) {
            System.out.println("No se encontró la historia clínica para la mascota con ID: " + petID);
            return;
        }
        System.out.println("Historia clínica de la mascota:");
        System.out.println(record);*/
    }

    private void registerClinicalRecord() throws Exception {
    	
    	System.out.println("Ingrese el ID de la historia clínica:");
        long historyID = clinicalRecordValidator.historyIDValidator(Utils.getReader().nextLine());

        
            System.out.println("Ingrese la fecha de registro de la mascota (YYYY-MM-DD):");
            String dateInput = Utils.getReader().nextLine();
            try {
                Date date = clinicalRecordValidator.dateValidator(dateInput, "Fecha de registro de la mascota");
                System.out.println("Fecha válida registrada: " + date);
            } catch (Exception e) {
                System.out.println("Error al registrar la fecha: " + e.getMessage());
            }
        
       
        System.out.println("Ingrese la cédula del veterinario:");
        long veterinarianCedula = userValidator.longValidator(Utils.getReader().nextLine(), "Cédula del veterinario");
        User veterinarian = userPort.findByPersonId(veterinarianCedula);
        if (veterinarian == null || !veterinarian.getRole().equalsIgnoreCase("veterinarian")) {
            throw new Exception("El veterinario con cédula " + veterinarianCedula + " no está registrado o no tiene el rol de veterinario.");
        }
        
        System.out.println("Ingrese el motivo de consulta:");
        String consultationReason = clinicalRecordValidator.consultationReasonValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese la sintomatología:");
        String symptoms = clinicalRecordValidator.symptomsValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese el diagnóstico:");
        String diagnosis = clinicalRecordValidator.diagnosisValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese el procedimiento:");
        String procedure = clinicalRecordValidator.procedureValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese el medicamento (si aplica):");
        String medication = clinicalRecordValidator.medicationValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese la dosis del medicamento (si aplica):");
        String dosage = clinicalRecordValidator.dosageValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese el historial de vacunación (si aplica):");
        String vaccinationHistory = clinicalRecordValidator.vaccinationHistoryValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese medicamentos a los que presenta alergia:");
        String allergyMedications = clinicalRecordValidator.allergyMedicationsValidator(Utils.getReader().nextLine());

        System.out.println("Ingrese detalles adicionales del procedimiento:");
        String procedureDetails = clinicalRecordValidator.procedureDetailsValidator(Utils.getReader().nextLine());

        System.out.println("¿La orden fue anulada? (true/false):");
        boolean orderCanceled = clinicalRecordValidator.orderCanceledValidator(Utils.getReader().nextLine());

      
        ClinicalRecord clinicalRecord = new ClinicalRecord();
        clinicalRecord.setHistoryID(historyID);
        clinicalRecord.setDate(date);
        clinicalRecord.setVeterinarian(veterinarian);
        clinicalRecord.setConsultationReason(consultationReason);
        clinicalRecord.setSymptoms(symptoms);
        clinicalRecord.setDiagnosis(diagnosis);
        clinicalRecord.setProcedure(procedure);
        clinicalRecord.setMedication(medication);
        clinicalRecord.setDosage(dosage);
        clinicalRecord.setVaccinationHistory(vaccinationHistory);
        clinicalRecord.setAllergyMedications(allergyMedications);
        clinicalRecord.setProcedureDetails(procedureDetails);
        clinicalRecord.setOrderCanceled(orderCanceled);

        System.out.println("Historia clínica registrada exitosamente.");
    }

    private void createMedicalOrder() throws Exception {
        System.out.println("Funcionalidad para crear una orden médica aún no implementada.");
        // Implementa la lógica para crear una orden médica aquí.
    }

    private void cancelMedicalOrder() throws Exception {
        System.out.println("Funcionalidad para anular una orden médica aún no implementada.");
        // Implementa la lógica para anular una orden médica aquí.
    }

	public ClinicalRecordValidator getHistoryValidator() {
		return clinicalRecordValidator;
	}

	public void setHistoryValidator(ClinicalRecordValidator clinicalRecordValidator) {
		this.clinicalRecordValidator = clinicalRecordValidator;
	}
}



