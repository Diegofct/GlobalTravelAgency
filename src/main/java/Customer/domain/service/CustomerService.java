package Customer.domain.service;

import Customer.domain.entity.Customer;

public interface CustomerService {
    void createCustomer(Customer customer);
    void updateCustomer(Customer customer);
}
