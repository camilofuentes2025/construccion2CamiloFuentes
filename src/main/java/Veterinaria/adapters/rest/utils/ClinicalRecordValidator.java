package Veterinaria.adapters.rest.utils;

import java.sql.Date;

import org.springframework.stereotype.Component;

import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor
public class ClinicalRecordValidator extends SimpleValidator {

    public long historyIDValidator(String value) throws Exception {
    	return longValidator(value, " ID del historial clinico ");
    }
    
    public String dateValidator(String value) throws Exception {
        return stringValidator(value, "Fecha de creación de la orden");
    }

    public User veterinarianValidator(User user) throws Exception {
        if (user == null) {
            throw new Exception("El veterinario no puede ser nulo.");
        }
        return user;
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
        if (order == null) {
            throw new Exception("la orden no puede ser nulo.");
        }
        return order;
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