package Veterinaria.domain.services;

import Veterinaria.domain.models.Pet;
import Veterinaria.ports.PetPort;

public class VeterinarianService {
    PetPort petPort;

    public void register_attention(Pet pet)throws Exception{
        if (!petPort.existPet(pet.getPetID())) {
            throw new Exception("La mascota no esta registrada en el sistema");
        }

        





    }


    public void consult_medical_history(){
        
    }



}
