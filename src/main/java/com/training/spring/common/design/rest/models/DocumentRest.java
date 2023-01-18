package com.training.spring.common.design.rest.models;

import com.training.spring.common.design.EDocumentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class DocumentRest {
    @Enumerated(EnumType.STRING)
    private EDocumentType documentType;
    private String candidateUid;

}
