package com.training.spring.common.design;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Document {

    @Id
    @GeneratedValue
    private Long documentId;
    private String documentUid;
    @Enumerated(EnumType.STRING)
    private EDocumentType documentType;
    @Enumerated(EnumType.STRING)
    private EDocumentStatus documentStatus;
    private Long candidateId;

    @Transient
    private String candidateUid;
}
