package com.training.spring.di.data;

import com.training.spring.di.data.daos.IPersonDao;
import com.training.spring.di.services.models.AddressDto;
import com.training.spring.di.services.models.PersonDto;
import com.training.spring.di.services.models.PhoneDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PersonDbOperations {

    private IPersonDao personDao;

    public PersonDbOperations(IPersonDao personDaoParam) {
        personDao = personDaoParam;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertOrUpdate(PersonDto personParam) {
        // rest
        // rest
        Set<PhoneDto> phones = personParam.getPhones();
        if (phones != null) {
            for (PhoneDto phone : phones) {
                phone.setPerson(personParam);
            }
        }

        Optional.of(personParam.getPhones())
                .orElse(new HashSet<>())
                .stream()
                .peek(p -> p.setPerson(personParam));
        AddressDto address = personParam.getAddress();
        if (address != null) {
            address.setPerson(personParam);
        }
        personDao.save(personParam);
        //personDao.save(personParam);
    }

    public void delete(Long personId) {
        personDao.deleteById(personId);
    }

    public PersonDto getOne(Long personId) {
        return personDao.findById(personId)
                        .orElse(null);
    }

    public List<PersonDto> getAll() {
        return personDao.findAll();
    }

    @Transactional(propagation = Propagation.MANDATORY, noRollbackFor = NullPointerException.class, isolation = Isolation.READ_UNCOMMITTED)
    public void otherOperation(PersonDto personParam) {
        // personDao.save(personParam);
    }
}
