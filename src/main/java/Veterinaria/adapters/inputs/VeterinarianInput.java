package Veterinaria.adapters.inputs;

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
    private PetValidator petValidator;
    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;

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
    	
        System.out.println("Ingrese el ID de la mascota:");
        long petID = petValidator.petIDValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el ID de la historia clinica:");
        long historyID = clinicalRecordValidator.historyIDValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el motivo de consulta:");
        String consultationReason = clinicalRecordValidator.consultationReasonValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese la sintomatología:");
        String symptoms = clinicalRecordValidator.symptomsValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el diagnóstico:");
        String diagnosis = clinicalRecordValidator.diagnosisValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el procedimiento:");
        String procedure = clinicalRecordValidator.procedureValidator(Utils.getReader().nextLine());

        ClinicalRecord clinicalRecord = new ClinicalRecord();
        clinicalRecord.setHistoryID(historyID);
        clinicalRecord.setPetID(petID);
        clinicalRecord.setConsultationReason(consultationReason);
        clinicalRecord.setSymptoms(symptoms);
        clinicalRecord.setDiagnosis(diagnosis);
        clinicalRecord.setProcedure(procedure);
        //clinicalRecord.setDateCreated(new java.sql.Date(System.currentTimeMillis()));

        clinicalRecordPort.saveClinicalRecord(clinicalRecord);
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



