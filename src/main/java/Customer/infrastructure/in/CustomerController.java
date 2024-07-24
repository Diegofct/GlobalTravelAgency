package Customer.infrastructure.in;

import java.util.Scanner;

import Customer.application.CreateCustomerUseCase;
import Customer.application.UpdateCustomerUseCase;
import Customer.domain.entity.Customer;

public class CustomerController {
    private final CreateCustomerUseCase createCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase,
            UpdateCustomerUseCase updateCustomerUseCase) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
    }

    public void createCustomer() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Registre el id del Cliente: ");
            int idCustomer = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Registre el nombre del Cliente: ");
            String name = scanner.nextLine();

            System.out.println("Registre edad del Cliente: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Indique el id del tipo de documento: ");
            int idDocumentType = scanner.nextInt();
            scanner.nextLine();

            Customer customer = new Customer();
            customer.setIdCustomer(idCustomer);
            customer.setName(name);
            customer.setAge(age);
            customer.setIdDocumentType(idDocumentType);

            createCustomerUseCase.createCustomer(customer);

        } catch (Exception e) {
            System.out.println("Error al registrar el cliente");
        }
        System.out.println("Cliente se registro exitosamente");
    }
}
