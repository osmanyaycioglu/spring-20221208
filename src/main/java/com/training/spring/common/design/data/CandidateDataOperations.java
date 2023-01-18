package com.training.spring.common.design.data;

import com.training.spring.common.design.Candidate;
import com.training.spring.common.design.Company;
import com.training.spring.common.design.daos.ICandidateDao;
import com.training.spring.common.design.daos.ICompanyDao;
import org.springframework.stereotype.Service;

@Service
public class CandidateDataOperations {

    ICandidateDao candidateDao;
    ICompanyDao companyDao;

    public CandidateDataOperations(ICandidateDao candidateDaoParam,
                                   ICompanyDao companyDaoParam) {
        candidateDao = candidateDaoParam;
        companyDao = companyDaoParam;
    }

    public void insertCandidate(Candidate candidateParam,
                                String companyUidParam){
        Company byCompanyUid = companyDao.findByCompanyUid(companyUidParam);
        if (byCompanyUid == null){
            throw new IllegalArgumentException("Yanlış company UUID !");
        }
        candidateParam.setCompanyId(byCompanyUid.getCompanyId());
        candidateDao.save(candidateParam);
    }
}
