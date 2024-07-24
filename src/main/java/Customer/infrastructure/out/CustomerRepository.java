package Customer.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Customer.domain.entity.Customer;
import Customer.domain.service.CustomerService;
import DBConnection.config.DatabaseConfig;

public class CustomerRepository implements CustomerService{

    @Override
    public void createCustomer(Customer customer) {
        String sql = "INSERT INTO Customer (idCustomer, name, age, idDocumentType) VALUES (?,?,?,?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, customer.getIdCustomer());
            statement.setString(2, customer.getName());
            statement.setInt(3, customer.getAge());
            statement.setInt(4, customer.getIdDocumentType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }
    
}
