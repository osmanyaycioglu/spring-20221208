package com.training.spring.di.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.spring.di.rest.mappers.IPersonMapper;
import com.training.spring.di.rest.models.Person;
import com.training.spring.di.services.PersonProvisionService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController {

    private final PersonProvisionService personProvisionService;

    @Autowired
    public PersonProvisionController(final PersonProvisionService personProvisionServiceParam) {
        this.personProvisionService = personProvisionServiceParam;
    }

    @Operation(summary = "yeni person ekle", description = "Şunu bunu girin verilen kişi database yazılır")
    @PostMapping("/add")
    public String add(@Valid @RequestBody final Person personParam) {
        this.personProvisionService.addPerson(IPersonMapper.personMapper.toPersonDto(personParam));
        return "OK";
    }

    // yeni ekleneni ekle
    @PostMapping("/addxyz")
    public String addXyx(@RequestBody final Person personParam) {
        return "OK";
    }

    @GetMapping("/enable")
    public String enable(@RequestParam("pid") final Long personId) {
        return "OK";
    }

}
