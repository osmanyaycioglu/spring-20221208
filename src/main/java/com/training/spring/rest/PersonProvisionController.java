package com.training.spring.rest;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/person/provision")
public class PersonProvisionController {

    @Operation(summary = "yeni person ekle",
            description = "Şunu bunu girin verilen kişi database yazılır")
    @PostMapping("/add")
    public String add(@RequestBody Person personParam) {
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
