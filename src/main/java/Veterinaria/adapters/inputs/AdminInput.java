package Veterinaria.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Veterinaria.adapters.inputs.utils.PersonValidator;
import Veterinaria.adapters.inputs.utils.UserValidator;
import Veterinaria.adapters.inputs.utils.Utils;
import Veterinaria.domain.models.User;
//import Veterinaria.domain.models.Partner;
import Veterinaria.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class AdminInput implements InputPort {

    @Autowired
    private PersonValidator personValidator;
    @Autowired
    private UserValidator userValidator;

    private final String MENU = "Ingrese la opción:"
            + "\n 1. Registrar nuevo veterinario."
            + "\n 2. Registrar nuevo vendedor."
            + "\n 3. Consultar usuarios registrados."
            + "\n 4. Eliminar un usuario."
            + "\n 5. Salir.";

    public void menu() {
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
        switch (option) {
            case "1": {
                try {
                    this.registerUser("veterinarian");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "2": {
                try {
                    this.registerUser("dealer");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "3": {
                this.viewUsers();
                break;
            }
            case "4": {
                try {
                    this.deleteUser();
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

    private void registerUser(String role) throws Exception {
        System.out.println("Ingrese el nombre del " + role + ":");
        String name = personValidator.nameValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el ID del " + role + ":");
        long id = personValidator.idValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese la edad del " + role + ":");
        long age = personValidator.ageValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese el nombre de usuario del " + role + ":");
        String userName = userValidator.usernameValidator(Utils.getReader().nextLine());
        System.out.println("Ingrese la contraseña del " + role + ":");
        String password = userValidator.passwordValidator(Utils.getReader().nextLine());

        User user = new User();
        user.setName(name);
        user.setId(id);
        user.setAge(age);
        user.setUsername(userName);
        user.setPassword(password);
        user.setRole(role);

        System.out.println(role + " registrado exitosamente.");
    }

    private void viewUsers() {
        
        System.out.println("Mostrando lista de usuarios registrados...");
        // Falta crear la lista para ver el numero de usuarios registrados
    }

    private void deleteUser() throws Exception {
        System.out.println("Ingrese el ID del usuario que desea eliminar:");
        long id = personValidator.idValidator(Utils.getReader().nextLine());

        // Aquí debería verificarse y eliminar el usuario del sistema.
        System.out.println("Usuario con cédula " + id + " eliminado exitosamente.");
    }
}

/*public class AdminInput  implements InputPort{
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;

	private final String MENU = "Ingrese la opcion:"
			
			+ " \n 1. Gestion de Usuarios"
			+"   - Registrar nuevos veterinarios"
			+"   - Registrar nuevos vendedores"
			+"   - Consultar usuarios registrados (veterinarios y vendedores)"
			+"   - Eliminar usuarios existentes (veterinarios o vendedores)"
			
			+ " \n 2. Gestion de Mascotas"
			+ "   - Registrar nuevas mascotas"
			+ "   - Consultar mascotas registradas"
			+ "   - Actualizar información de una mascota"
			
			+ " \n 3. Historial Médico:"
			+ "   - Consultar historial médico de mascotas (acceso restringido para veterinarios)"
			+ "   - Asociar veterinario a historial médico"
			
			+ " \n 4. Gestión de Órdenes:"
			+ "   - Consultar órdenes activas"
			+ "   - Eliminar órdenes anuladas por veterinarios"
			+ "   - Consultar historial de órdenes"
			
			+ " \n 5. Gestión de Facturas:"
			+ "   - Consultar facturas generadas"
			+ "   - Ver detalles de una factura"
	
			+ " \n 6. Configuración del Sistema:"
			+ "   - Cambiar roles de usuarios"
			+ "   - Configurar parámetros del sistema (limpieza de datos en memoria)"
			+ "   - Cerrar sesión o cambiar de rol";
  
    /*1. Gestión de Usuarios: Registrar, consultar y eliminar usuarios.
     *2.  Gestión de Mascotas: Registrar y consultar mascotas.
     *3.  Historial Médico: Consultar historial médico.
     *4.  Gestión de Órdenes: Consultar órdenes activas.
     *5.  Cerrar Sesión.
     * 
	public void menu() {
		System.out.println(MENU);
		String option = Utils.getReader().nextLine();
		switch (option){
		case "1":{
			try {
				this.createVeterinarian();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		default :
			System.out.println("opcion no valida");
		}
	}
	
	private void createVeterinarian()  throws Exception{
		System.out.println("ingrese el nombre del socio");
		String name = personValidator.nameValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el documento del socio");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el numero celular del socio");
		long cellPhone = personValidator.cellPhoneValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el userName del socio");
		String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
		System.out.println("ingrese la contraseña socio");
		String password = userValidator.passwordValidator(Utils.getReader().nextLine());
		Partner partner = new Partner();
		partner.setDocument(document);
		partner.setName(name);
		partner.setCellPhone(cellPhone);
		partner.setUserName(userName);
		partner.setPassword(password);
		partner.setRole("partner");
		
	}
}*/
