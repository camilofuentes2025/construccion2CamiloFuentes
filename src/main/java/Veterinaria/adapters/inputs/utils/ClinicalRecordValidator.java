package Veterinaria.adapters.inputs.utils;


import java.sql.Date;

import org.springframework.stereotype.Component;

import Veterinaria.adapters.inputs.utils.SimpleValidator;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;

@Component
public class ClinicalRecordValidator extends SimpleValidator {

    public long historyIDValidator(String value) throws Exception {
    	return longValidator(value, " ID del historial clinico ");
    }
    
    public Date dateValidator(String dateInput) throws Exception {
        return dateValidator(dateInput, "Fecha de creación de la orden");
    }

    public User veterinarianValidator(User user) throws Exception {
    	return userValidator(user, " ID del veterinario que atendio ");
    }
    
    public String consultationReasonValidator(String value) throws Exception {
    	return stringValidator(value, " motivo de la consulta ");
    }
    
    public String symptomsValidator(String value) throws Exception {
    	return stringValidator(value, " sintomalogia ");
    }
    
    public String diagnosisValidator(String value) throws Exception {
    	return stringValidator(value, " diagnostico ");
    }
    
    public String procedureValidator(String value) throws Exception {
    	return stringValidator(value, " procedimiento ");
    }
    
    public String medicationValidator(String value) throws Exception {
    	return stringValidator(value, " medicina ");
    }
    
    public String dosageValidator(String value) throws Exception {
    	return stringValidator(value, " dosis ");
    }
    
    public Order orderValidator(Order order) throws Exception {
    	return orderValidator(order, " ID de la orden ");
    }
    
    public String vaccinationHistoryValidator(String value) throws Exception {
    	return stringValidator(value, " historial de vacunacion ");
    }
    
    public String allergyMedicationsValidator(String value) throws Exception {
    	return stringValidator(value, " alergias ");
    }
    
    public String procedureDetailsValidator(String value) throws Exception {
    	return stringValidator(value, " detalle del procedimiento ");
    }
    
    public boolean orderCanceledValidator(String value) throws Exception {
    	return booleanValidator(value, " orden cancelada ");
    }
    
}