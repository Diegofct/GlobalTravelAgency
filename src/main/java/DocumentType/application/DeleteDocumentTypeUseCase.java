package DocumentType.application;

import DocumentType.domain.service.DocumentTypeService;

public class DeleteDocumentTypeUseCase {
    private final DocumentTypeService documentTypeService;

    public DeleteDocumentTypeUseCase(DocumentTypeService documentTypeService) {
        this.documentTypeService = documentTypeService;
    }

    public void deleteDocumentType(int idDocumentType) {
        documentTypeService.deleteDocumentType(idDocumentType);
    }
}
