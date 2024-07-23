package DocumentType.application;

import DocumentType.domain.entity.DocumentType;
import DocumentType.domain.service.DocumentTypeService;

public class CreateDocumentTypeUseCase {
    private final DocumentTypeService documentTypeService;

    public CreateDocumentTypeUseCase(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    public void createDocumentType(DocumentType documentType) {
        documentTypeService.createDocumentType(documentType);
    }
}
