package Customer.domain.entity;

public class Customer {
    private int idCustomer;
    private String name;
    private int age;
    private int idDocumentType;
    
    public Customer() {
    }

    public Customer(int idCustomer, String name, int age, int idDocumentType) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.age = age;
        this.idDocumentType = idDocumentType;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(int idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    
}
