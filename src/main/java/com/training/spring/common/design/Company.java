package com.training.spring.common.design;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Company {
    @Id
    @GeneratedValue
    private Long    companyId;
    private String  companyUid;
    private String  companyName;
    private String  city;
    private String  taxNumber;
    private EStatus companyStatus;

    @PrePersist
    public void preInsert(){
        companyUid = UUID.randomUUID().toString();
    }
}
