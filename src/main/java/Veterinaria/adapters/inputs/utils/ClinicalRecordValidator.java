package Veterinaria.adapters.inputs.utils;


import java.sql.Date;

import org.springframework.stereotype.Component;

import Veterinaria.adapters.inputs.utils.SimpleValidator;

@Component
public class ClinicalRecordValidator extends SimpleValidator {

    public long historyIDValidator(String value) throws Exception {
    	return longValidator(value, " ID del historial clinico ");
    }

    public User veterinarianValidator(String value) throws Exception {
    	return userValidator(value, " ID del veterinario que atendio ");
    }

    public Order orderValidator(String value) throws Exception {
    	return orderValidator(value, " ID de la orden ");
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
}