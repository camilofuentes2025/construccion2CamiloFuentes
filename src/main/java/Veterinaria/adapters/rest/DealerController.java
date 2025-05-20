package Veterinaria.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import Veterinaria.Exceptions.BusinessException;
import Veterinaria.Exceptions.InputsException;
import Veterinaria.adapters.rest.request.InvoiceRequest;
import Veterinaria.adapters.rest.utils.InvoiceValidator;
import Veterinaria.adapters.rest.utils.OrderValidator;
import Veterinaria.adapters.rest.utils.PersonValidator;
import Veterinaria.adapters.rest.utils.PetValidator;
import Veterinaria.domain.models.Invoice;
import Veterinaria.domain.models.Order;
import Veterinaria.domain.models.Person;
import Veterinaria.domain.models.Pet;
import Veterinaria.domain.services.DealerService;
import Veterinaria.domain.services.VeterinarianService;

@RestController
public class DealerController {

    @Autowired
    private DealerService dealerService;

    @Autowired
    private VeterinarianService veterinarianService;

    @Autowired
    private InvoiceValidator invoiceValidator;

    @PostMapping("/sale")
    public ResponseEntity<String> createSale(@RequestBody InvoiceRequest request) {
        System.out.println("Owner recibido: " + request.getOwner());
        
        try {
            System.out.println("Request recibido: " + request);

            // 🔹 Validar que los datos no sean `null`
            if (request.getPet() == null || request.getPet().getPetID() <= 0) {
                throw new InputsException("Error: La factura debe estar asociada a una mascota válida.");
            }
            if (request.getOwner() == null || request.getOwner().getId() <= 0) {
                throw new InputsException("Error: La factura debe estar asociada a un dueño válido.");
            }
            if (request.getOrder() == null) {
                throw new InputsException("Error: La factura debe estar asociada a una orden válida.");
            }

            Invoice invoice = new Invoice();

            // 🔹 Registrar la orden antes de asignarla a la factura
            Order order = request.getOrder();
            if (order.getOrderID() <= 0) {
                order = veterinarianService.createOrder(order); // Registrar nueva orden si es necesario
            }
            invoice.setOrder(order);

            invoice.setPet(request.getPet());
            invoice.setOwner(request.getOwner());
            invoice.setMedicine(invoiceValidator.medicineValidator(request.getMedicine()));
            invoice.setPrice(invoiceValidator.priceValidator(request.getPrice()));
            invoice.setAmount(invoiceValidator.amountValidator(request.getAmount()));

            // 🔹 Imprimir `owner` antes de guardar la factura en la BD
            System.out.println("Owner en factura antes de guardar en BD: " + invoice.getOwner());

            dealerService.registerSale(invoice);
            return new ResponseEntity<>("Se ha creado la venta correctamente.", HttpStatus.OK);

        } catch (BusinessException be) {
            return new ResponseEntity<>(be.getMessage(), HttpStatus.CONFLICT);
        } catch (InputsException ie) {
            return new ResponseEntity<>(ie.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}