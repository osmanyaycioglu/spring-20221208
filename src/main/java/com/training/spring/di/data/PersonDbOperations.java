package com.training.spring.di.data;

import com.training.spring.di.data.daos.IPersonDao;
import com.training.spring.di.services.models.PersonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonDbOperations {

    private IPersonDao personDao;

    public PersonDbOperations(IPersonDao personDaoParam) {
        personDao = personDaoParam;
    }

    public void insert(PersonDto personParam) {
        // rest
        // rest
        System.out.println("person : " + personParam);
        personDao.save(personParam);
    }
}
