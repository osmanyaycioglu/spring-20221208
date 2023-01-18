package com.training.spring.common.design.rest;

import com.training.spring.common.design.rest.mappers.ICandidateMapper;
import com.training.spring.common.design.rest.models.CandidateRest;
import com.training.spring.common.design.services.CandidateProvisionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gui/v1/candidate/provision")
public class CandidateProvisionController {

    private CandidateProvisionService candidateProvisionService;

    public CandidateProvisionController(CandidateProvisionService candidateProvisionServiceParam) {
        candidateProvisionService = candidateProvisionServiceParam;
    }

    @PostMapping("/add")
    public String addCandidate(@RequestBody CandidateRest candidateRestParam) {
        candidateProvisionService.add(ICandidateMapper.candidateMapper.toCandidate(candidateRestParam),
                                      candidateRestParam.getCompanyUid());
        return "OK";
    }


}
