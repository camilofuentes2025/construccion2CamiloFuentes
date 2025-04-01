package Veterinaria.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Veterinaria.adapters.inputs.utils.ClinicalRecordValidator;
import Veterinaria.adapters.inputs.utils.InvoiceValidator;
import Veterinaria.adapters.inputs.utils.OrderValidator;
import Veterinaria.adapters.inputs.utils.Utils;
import Veterinaria.domain.models.Invoice;
import Veterinaria.domain.models.Order;
import Veterinaria.ports.InvoicePort;
import Veterinaria.ports.OrderPort;
import Veterinaria.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class DealerInput implements InputPort {

    @Autowired
    private OrderValidator orderValidator;
    @Autowired
    private OrderPort orderPort;
    @Autowired
    private InvoicePort invoicePort;
    @Autowired
    private ClinicalRecordValidator clinicalRecordValidator;
    @Autowired
    private InvoiceValidator invoiceValidator;

    private final String MENU = "Ingrese la opción:"
            + "\n 1. Consultar órdenes activas."
            + "\n 2. Suministrar medicamento mediante una orden."
            + "\n 3. Vender productos no asociados a órdenes."
            + "\n 4. Salir.";

    @Override
    public void menu() {
        System.out.println(MENU);
        String option = Utils.getReader().nextLine();
        switch (option) {
            case "1": {
                this.viewActiveOrders();
                break;
            }
            case "2": {
                try {
                    this.supplyMedication();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "3": {
                try {
                    //this.sellProduct();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            }
            case "4": {
                System.out.println("Hasta una próxima ocasión.");
                return;
            }
            default: {
                System.out.println("Opción no válida.");
            }
        }
    }

    private void viewActiveOrders() {
        System.out.println("Consultando órdenes activas...");
        // Obtener la lista de órdenes activas
        for (Order order : orderPort.findAllOrders()) {
            System.out.println(order);
        }
    }

    private void supplyMedication() throws Exception {
        System.out.println("Ingrese el ID de la orden:");
        long orderID = orderValidator.orderIDValidator(Utils.getReader().nextLine());
        Order order = orderPort.findByOrderID(orderID);
        if (order == null) {
            System.out.println("No se encontró la orden con ID: " + orderID);
            return;
        }

        System.out.println("Suministrando medicamento: " + order.getMedicine());

        // Validar cantidad suministrada para 'amount'
        System.out.println("Ingrese la cantidad suministrada:");
        long amount;
        try {
            amount = invoiceValidator.amountValidator(Utils.getReader().nextLine());
        } catch (Exception e) {
            System.out.println("Error al registrar la cantidad: " + e.getMessage());
            return;
        }

        // Crear factura
        Invoice invoice = new Invoice();
        invoice.setOrder(order); // Asocia la factura con la orden
        invoice.setMedicine(order.getMedicine()); // Asigna el nombre del medicamento
        invoice.setAmount(amount); // Asigna la cantidad suministrada (amount)
        //invoice.setPrice(calculatePrice(order.getMedicine(), amount)); // Calcula el precio basado en la cantidad
        invoice.setDateCreated(new java.sql.Date(System.currentTimeMillis())); // Registra la fecha actual
        invoice.setPet(order.getPet()); // Asocia la mascota
        invoice.setOwner(order.getOwner()); // Asocia el dueño

        // Guardar factura
        invoicePort.saveInvoice(invoice);

        System.out.println("El medicamento ha sido suministrado y se generó la factura:");
        System.out.println(invoice);
    }

    /*private void sellProduct() throws Exception {
        System.out.println("Ingrese el nombre del producto:");
        String productName = Utils.getReader().nextLine();
        System.out.println("Ingrese el valor del producto:");
        int price = Integer.parseInt(Utils.getReader().nextLine());
        System.out.println("Ingrese la cantidad vendida:");
        long quantity = orderValidator.validateQuantity(Utils.getReader().nextLine());

        Invoice invoice = new Invoice();
        invoice.setMedicine(productName); // Para productos, usamos el campo "medicine" como nombre genérico
        invoice.setAmount(quantity);
        invoice.setPrice(price * quantity);
        invoice.setDateCreated(new java.sql.Date(System.currentTimeMillis()));

        invoicePort.saveInvoice(invoice);

        System.out.println("El producto ha sido vendido y se generó la factura:");
        System.out.println(invoice);
    }*/
}