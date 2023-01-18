package com.training.spring.common.design.daos;

import com.training.spring.common.design.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentDao extends JpaRepository<Document,Long> {
}
