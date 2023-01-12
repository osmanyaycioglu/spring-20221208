package com.training.spring.di.services;

import com.training.spring.di.data.PersonDbOperations;
import com.training.spring.di.services.models.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonProvisionService {

    private PersonDbOperations personDbOperations;

    public PersonProvisionService(PersonDbOperations personDbOperationsParam) {
        personDbOperations = personDbOperationsParam;
    }

    public void addPerson(PersonDto personDtoParam) {
        // Rest call -> entegrasyon layer
        // Web service
        personDbOperations.insert(personDtoParam);
    }

}
