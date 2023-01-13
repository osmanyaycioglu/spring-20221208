package com.training.spring.di.services;

import com.training.spring.di.data.PersonDbOperations;
import com.training.spring.di.services.models.PersonDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonProvisionService {

    private PersonDbOperations personDbOperations;

    public PersonProvisionService(PersonDbOperations personDbOperationsParam) {
        personDbOperations = personDbOperationsParam;
    }

    @Transactional
    public void addPerson(PersonDto personDtoParam) {
        // Rest call -> entegrasyon layer
        // Web service
        personDbOperations.insertOrUpdate(personDtoParam);
        personDbOperations.otherOperation(personDtoParam);
    }

}
