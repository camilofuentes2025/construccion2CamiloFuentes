package Veterinaria.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Veterinaria.adapters.inputs.utils.PersonValidator;
import Veterinaria.adapters.inputs.utils.UserValidator;
import Veterinaria.adapters.inputs.utils.Utils;
//import Veterinaria.domain.models.Partner;
import Veterinaria.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class AdminInput  implements InputPort{
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
     * */
	public void menu() {
		System.out.println(MENU);
		String option = Utils.getReader().nextLine();
		switch (option){
		case "1":{
			try {
				this.createPartner();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		default :
			System.out.println("opcion no valida");
		}
	}
	
	private void createPartner()  throws Exception{
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
}
