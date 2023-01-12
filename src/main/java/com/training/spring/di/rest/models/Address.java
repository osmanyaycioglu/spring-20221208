package com.training.spring.di.rest.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Address {
    @NotEmpty
    private String city;
    @NotEmpty
    private String street;

}
