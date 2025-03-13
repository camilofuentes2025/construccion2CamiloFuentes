package Veterinaria.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private ClinicalRecord orderID;
    private Pet pet;
    private Person owner;
    private User veterinarian;
    private ClinicalRecord clinicalRecord;
    private String date;
}
