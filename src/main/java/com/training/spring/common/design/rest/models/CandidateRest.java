package com.training.spring.common.design.rest.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CandidateRest {

    private String    firstName;
    private String    middleName;
    private String    lastName;
    private String    identityNumber;
    private LocalDate birthdate;
    private String    username;
    private String    password;
    private String    companyUid;

}
