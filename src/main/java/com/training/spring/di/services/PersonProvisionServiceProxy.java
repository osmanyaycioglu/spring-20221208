package com.training.spring.di.services;

import com.training.spring.di.data.PersonDbOperations;
import com.training.spring.di.services.models.PersonDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


public class PersonProvisionServiceProxy extends PersonProvisionService {

    private PersonDbOperations personDbOperations;

    public PersonProvisionServiceProxy(PersonDbOperations personDbOperationsParam) {
        super(personDbOperationsParam);
    }

    public void addPerson(PersonDto personDtoParam) {
        EntityManager entityManager = null;
        try {
            entityManager.getTransaction().begin();
            super.addPerson(personDtoParam);
            entityManager.getTransaction().commit();

        } catch (Exception eParam) {
            entityManager.getTransaction().rollback();
        }
    }

}
