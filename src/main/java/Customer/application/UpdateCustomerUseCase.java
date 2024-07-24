package Customer.application;

import Customer.domain.entity.Customer;
import Customer.domain.service.CustomerService;

public class UpdateCustomerUseCase {
    private final CustomerService customerService;

    public UpdateCustomerUseCase(CustomerService customerService) {
        this.customerService = customerService;
    }

    public void updateCustomer(Customer customer) {
        customerService.updateCustomer(customer);
    }
}
