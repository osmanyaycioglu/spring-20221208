package com.training.spring.common.design.rest.mappers;

import com.training.spring.common.design.Candidate;
import com.training.spring.common.design.rest.models.CandidateRest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ICandidateMapper {

    ICandidateMapper candidateMapper = Mappers.getMapper(ICandidateMapper.class);

    @Mapping(source = "candidate.username", target = "user.username")
    @Mapping(source = "candidate.password", target = "user.password")
    Candidate toCandidate(CandidateRest candidate);

}
