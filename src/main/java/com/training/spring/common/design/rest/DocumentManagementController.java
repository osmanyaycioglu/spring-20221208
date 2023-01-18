package com.training.spring.common.design.rest;

import com.training.spring.common.design.rest.mappers.IDocumentMapper;
import com.training.spring.common.design.rest.models.DocumentRest;
import com.training.spring.common.design.services.DocumentManagementService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/gui/v1/document/management")
public class DocumentManagementController {

    private DocumentManagementService documentManagementService;

    public DocumentManagementController(DocumentManagementService documentManagementServiceParam) {
        documentManagementService = documentManagementServiceParam;
    }

    @PostMapping("/upload")
    public String uploadDocument(@RequestParam("file") MultipartFile multipartFileParam,
                                 @RequestBody DocumentRest documentRestParam) throws IOException {
        documentManagementService.addDocument(multipartFileParam,
                                              IDocumentMapper.documentMapper.toDocument(documentRestParam));
        return "OK";
    }

}
