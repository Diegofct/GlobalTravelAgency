package DocumentType.infrastructure.in;

import java.util.Scanner;

import DocumentType.application.CreateDocumentTypeUseCase;
import DocumentType.application.DeleteDocumentTypeUseCase;
import DocumentType.application.ReadDocumentTypeUseCase;
import DocumentType.application.UpdateDocumentTypeUseCase;
import DocumentType.domain.entity.DocumentType;

public class DocumentTypeController {
    private final CreateDocumentTypeUseCase createDocumentTypeUseCase;
    private final DeleteDocumentTypeUseCase deleteDocumentTypeUseCase;
    private final ReadDocumentTypeUseCase readDocumentTypeUseCase;
    private final UpdateDocumentTypeUseCase updateDocumentTypeUseCase;

    public DocumentTypeController(CreateDocumentTypeUseCase createDocumentTypeUseCase,
            DeleteDocumentTypeUseCase deleteDocumentTypeUseCase, ReadDocumentTypeUseCase readDocumentTypeUseCase,
            UpdateDocumentTypeUseCase updateDocumentTypeUseCase) {
        this.createDocumentTypeUseCase = createDocumentTypeUseCase;
        this.deleteDocumentTypeUseCase = deleteDocumentTypeUseCase;
        this.readDocumentTypeUseCase = readDocumentTypeUseCase;
        this.updateDocumentTypeUseCase = updateDocumentTypeUseCase;
    }

    public void createDocumentType() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite el id del Tipo de documento: ");
            int idDocumentType = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Digite el tipo de documento: ");
            String name = scanner.nextLine();

            System.out.println("Ingrese el número de documento: ");
            String documentNumber = scanner.nextLine();

            DocumentType documentType = new DocumentType();
            documentType.setIdDocumentType(idDocumentType);
            documentType.setName(name);
            documentType.setDocumentNumber(documentNumber);

            createDocumentTypeUseCase.createDocumentType(documentType);

        } catch (Exception e) {
            System.out.println("Error al registrar el tipo de documento");
        }
        System.out.println("Tipo de documento creado con exito");
    }
}
