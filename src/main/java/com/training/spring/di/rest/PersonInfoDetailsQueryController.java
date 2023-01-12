package com.training.spring.di.rest;

import com.training.spring.di.rest.models.Person;
import com.training.spring.di.rest.models.PersonInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person/details/query")
public class PersonInfoDetailsQueryController {

    @GetMapping("/get/one")
    public PersonInfo getPerson(Long personId){
        return null;
    }
}
