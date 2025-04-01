package Veterinaria.adapters.inputs;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import Veterinaria.adapters.inputs.utils.UserValidator;
import Veterinaria.adapters.inputs.utils.Utils;
import Veterinaria.domain.models.User;
import Veterinaria.ports.InputPort;

public class LoginInput implements InputPort {

    private Map<String, InputPort> inputs;
    @Autowired
    private AdminInput adminInput;
    @Autowired
    private VeterinarianInput veterinarianInput;
    @Autowired
    private DealerInput dealerInput;
    @Autowired
    private OwnerInput ownerInput;
    @Autowired
    private UserValidator userValidator;

    private final String MENU = "Ingrese la opción que desea:\n 1. Iniciar sesión\n 2. Salir";

    public LoginInput(AdminInput adminInput, VeterinarianInput veterinarianInput, DealerInput sellerInput, OwnerInput ownerInput) {
        super();
        this.adminInput = adminInput;
        this.veterinarianInput = veterinarianInput;
        this.dealerInput = dealerInput;
        this.ownerInput = ownerInput;

        this.inputs = new HashMap<>();
        inputs.put("admin", adminInput);
        inputs.put("veterinarian", veterinarianInput);
        inputs.put("seller", sellerInput);
        inputs.put("owner", ownerInput);
    }

    @Override
    public void menu() throws Exception {
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
        switch (option) {
            case "1": {
                this.login();
                break;
            }
            case "2": {
                System.out.println("Hasta una próxima ocasión");
                return;
            }
            default: {
                System.out.println("Ha elegido una opción inválida. Se detiene la ejecución.");
                return;
            }
        }
    }

    private void login() {
        try {
            System.out.println("Ingrese su usuario:");
            String username = userValidator.usernameValidator(Utils.getReader().nextLine());
            System.out.println("Ingrese su contraseña:");
            String password = userValidator.passwordValidator(Utils.getReader().nextLine());
            
            User user = new User();
            InputPort inputPort = inputs.get(user.getRole());
            if (inputPort !=null) {
            	inputPort.menu();
            }else {
            	System.out.println("no tienes acceso");
            }
           
            /*User user = userValidator.usernameValidatorandpasswordValidator(username, password); 
            if (user == null) {
                System.out.println("Usuario o contraseña incorrectos.");
                return;
            }

            // Obtener el input correspondiente al rol
            InputPort inputPort = inputs.get(user.getRole());
            if (inputPort == null) {
                System.out.println("Rol no reconocido: " + user.getRole());
                return;
            }

            // Mostrar menú según el rol
            inputPort.menu();*/
        } catch (Exception e) {
            System.out.println("Error durante el inicio de sesión: " + e.getMessage());
        }
    }
}
