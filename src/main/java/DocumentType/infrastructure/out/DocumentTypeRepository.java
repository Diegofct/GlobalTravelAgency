package DocumentType.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.config.DatabaseConfig;
import DocumentType.domain.entity.DocumentType;
import DocumentType.domain.service.DocumentTypeService;

public class DocumentTypeRepository implements DocumentTypeService{

    @Override
    public void createDocumentType(DocumentType documentType) {
        String sql = "INSERT INTO DocumentType (idDocumentType, name, documentNumber) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, documentType.getIdDocumentType());
            statement.setString(2, documentType.getName());
            statement.setString(3, documentType.getDocumentNumber());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateDocumentType(DocumentType documentType) {
        String sql = "UPDATE DocumentType SET name = ?, documentNumber = ? WHERE idDocumentType = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, documentType.getName());
            statement.setString(2, documentType.getDocumentNumber());
            statement.setInt(3, documentType.getIdDocumentType());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }        
    }

    @Override
    public void deleteDocumentType(int idDocumentType) {
        String sql = "DELETE FROM DocumentType WHERE idDocumentType = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idDocumentType);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DocumentType readDocumentType(int idDocumentType) {
        String sql = "SELECT * FROM DocumentType WHERE idDocumentType = ?";
        DocumentType documentType = null;
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, idDocumentType);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    documentType = new DocumentType();
                    documentType.setIdDocumentType(rs.getInt("idDocumentType"));
                    documentType.setName(rs.getString("name"));
                    documentType.setDocumentNumber(rs.getString("documentNumber"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documentType;        
    }
    
}
