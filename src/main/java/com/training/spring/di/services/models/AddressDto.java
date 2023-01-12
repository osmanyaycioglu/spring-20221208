package com.training.spring.di.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class AddressDto {
    private String city;
    private String street;

}
