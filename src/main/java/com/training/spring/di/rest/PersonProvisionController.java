package com.training.spring.di.rest;

import com.training.spring.di.rest.error.ErrorObj;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController {

    @Operation(summary = "yeni person ekle",
            description = "Şunu bunu girin verilen kişi database yazılır")
    @PostMapping("/add")
    public String add(@Valid @RequestBody Person personParam) {
        if (personParam.getName() == null) {
            throw new IllegalArgumentException("name null olamaz");
        }
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
