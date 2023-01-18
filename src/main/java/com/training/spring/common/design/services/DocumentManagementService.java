package com.training.spring.common.design.services;

import com.training.spring.common.design.Document;
import com.training.spring.common.design.EDocumentStatus;
import com.training.spring.common.design.data.DocumentDataOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class DocumentManagementService {

    private DocumentDataOperations documentDataOperations;

    public DocumentManagementService(DocumentDataOperations documentDataOperationsParam) {
        documentDataOperations = documentDataOperationsParam;
    }

    public void addDocument(MultipartFile multipartFileParam,
                            Document documentParam) throws IOException {
        documentParam.setDocumentStatus(EDocumentStatus.UPLOADED);
        documentParam.setDocumentUid(UUID.randomUUID()
                                         .toString());
        String contentType = multipartFileParam.getContentType();
        Files.write(Paths.get(documentParam.getDocumentUid() + ".pdf"),
                    multipartFileParam.getBytes());
        documentDataOperations.insertDocument(documentParam);
    }

}
