package Veterinaria;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@SpringBootApplication
public class VeterinariaApplication {

	public static void main(String[] args)  {
		SpringApplication.run(VeterinariaApplication.class, args);
	}

}
