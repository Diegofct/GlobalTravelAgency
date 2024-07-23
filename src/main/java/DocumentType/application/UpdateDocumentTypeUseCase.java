package DocumentType.application;

import DocumentType.domain.entity.DocumentType;
import DocumentType.domain.service.DocumentTypeService;

public class UpdateDocumentTypeUseCase {
    private final DocumentTypeService documentTypeService;

    public UpdateDocumentTypeUseCase(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    public void updateDocumentType(DocumentType documentType) {
        documentTypeService.updateDocumentType(documentType);
    }
}
