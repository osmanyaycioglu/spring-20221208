package com.training.spring.di.rest;

import com.training.spring.di.rest.models.Person;
import com.training.spring.di.services.PersonProvisionService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController {

    private PersonProvisionService personProvisionService;

    @Autowired
    public PersonProvisionController(PersonProvisionService personProvisionServiceParam) {
        personProvisionService = personProvisionServiceParam;
    }

    @Operation(summary = "yeni person ekle",
            description = "Şunu bunu girin verilen kişi database yazılır")
    @PostMapping("/add")
    public String add(@Valid @RequestBody Person personParam) {
        if (personParam.getName() == null) {
            throw new IllegalArgumentException("name null olamaz");
        }
        personProvisionService.addPerson(personParam);
        return "OK";
    }

    // yeni ekleneni ekle
    @PostMapping("/addxyz")
    public String addXyx(@RequestBody Person personParam) {
        return "OK";
    }

    @GetMapping("/enable")
    public String enable(@RequestParam("pid") Long personId) {
        return "OK";
    }


}
