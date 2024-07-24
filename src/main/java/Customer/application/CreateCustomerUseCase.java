package Customer.application;

import Customer.domain.entity.Customer;
import Customer.domain.service.CustomerService;

public class CreateCustomerUseCase {
    private final CustomerService customerService;

    public CreateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void createCustomer(Customer customer) {
        customerService.createCustomer(customer);
    }
}
