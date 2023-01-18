package com.training.spring.common.design.daos;

import com.training.spring.common.design.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyDao extends JpaRepository<Company,Long> {
    Company findByCompanyUid(String companyUid);
}
