package com.training.spring.common.design.data;

import com.training.spring.common.design.Candidate;
import com.training.spring.common.design.Document;
import com.training.spring.common.design.daos.ICandidateDao;
import com.training.spring.common.design.daos.IDocumentDao;
import org.springframework.stereotype.Service;

@Service
public class DocumentDataOperations {

    private IDocumentDao documentDao;
    private ICandidateDao candidateDao;

    public DocumentDataOperations(IDocumentDao documentDaoParam) {
        documentDao = documentDaoParam;
    }

    public void insertDocument(Document documentParam){
        Candidate byCandidateUid = candidateDao.findByCandidateUid(documentParam.getCandidateUid());
        if (byCandidateUid == null){
            throw new IllegalArgumentException("document aidat problemi");
        }
        documentParam.setCandidateId(byCandidateUid.getCandidateId());
        documentDao.save(documentParam);
    }
}
