package com.training.spring.common.design.daos;

import com.training.spring.common.design.Candidate;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICandidateDao extends JpaRepository<Candidate, Long> {

    // @EntityGraph("Candidate.basic")
    List<Candidate> findByCompany(Long companyId);

    // @EntityGraph(attributePaths = {"user"}, type = EntityGraph.EntityGraphType.LOAD)
    List<Candidate> findByCompany2(Long companyId);

    Candidate findByCandidateUid(String candidateUid);

}
