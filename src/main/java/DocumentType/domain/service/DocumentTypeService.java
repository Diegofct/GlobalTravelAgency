package DocumentType.domain.service;

import DocumentType.domain.entity.DocumentType;

public interface DocumentTypeService {
    void createDocumentType(DocumentType documentType);
    void updateDocumentType(DocumentType documentType);
    void deleteDocumentType(int idDocumentType);
    DocumentType readDocumentType(int idDocumentType);
}
