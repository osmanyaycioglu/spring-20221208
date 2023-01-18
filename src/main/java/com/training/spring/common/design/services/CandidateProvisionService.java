package com.training.spring.common.design.services;

import com.training.spring.common.design.Candidate;
import com.training.spring.common.design.data.CandidateDataOperations;
import org.springframework.stereotype.Service;

@Service
public class CandidateProvisionService {

    private CandidateDataOperations candidateDataOperations;

    public CandidateProvisionService(CandidateDataOperations candidateDataOperationsParam) {
        candidateDataOperations = candidateDataOperationsParam;
    }

    public void add(Candidate candidateParam,
                    String companyUidParam) {
        candidateDataOperations.insertCandidate(candidateParam,
                                                companyUidParam);
    }

}
