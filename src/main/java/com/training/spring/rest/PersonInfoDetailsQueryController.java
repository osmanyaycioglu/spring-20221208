package com.training.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/person/details/query")
public class PersonInfoDetailsQueryController {

    @GetMapping("/get/one")
    public Person getPerson(Long personId){
        return null;
    }
}
