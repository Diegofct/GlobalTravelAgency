package DocumentType.application;

import DocumentType.domain.entity.DocumentType;
import DocumentType.domain.service.DocumentTypeService;

public class ReadDocumentTypeUseCase {
    private final DocumentTypeService documentTypeService;

    public ReadDocumentTypeUseCase(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    public DocumentType getInfoDocumentTypeById(int idDocumentType) {
        DocumentType documentType = documentTypeService.readDocumentType(idDocumentType);
        return documentType;
    }
}
