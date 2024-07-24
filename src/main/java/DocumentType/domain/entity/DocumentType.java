package DocumentType.domain.entity;
// Clase "Tipo de Documento"
public class DocumentType {
    private int idDocumentType;
    private String name;
    private String documentNumber;
    
    // Empty constructor
    public DocumentType() {
    }
    // FUll constructor
    public DocumentType(int idDocumentType, String name, String documentNumber) {
        this.idDocumentType = idDocumentType;
        this.name = name;
        this.documentNumber = documentNumber;
    }
    // Getters and setters
    public int getIdDocumentType() {
        return idDocumentType;
    }

    public void setIdDocumentType(int idDocumentType) {
        this.idDocumentType = idDocumentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

}
