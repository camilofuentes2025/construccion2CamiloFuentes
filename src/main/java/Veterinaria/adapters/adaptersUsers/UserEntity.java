package Veterinaria.adapters.adaptersUsers;

import Veterinaria.adapters.adaptersPerson.PersonEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "userName")
    private String userName;
    @Column(name = "passWord")
	private String passWord;
    @JoinColumn(name="person_id")
	@OneToOne
	private PersonEntity personId;
    public long getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }
	
}
