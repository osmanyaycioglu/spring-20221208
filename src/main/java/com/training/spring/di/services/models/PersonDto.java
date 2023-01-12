package com.training.spring.di.services.models;

import com.training.spring.di.rest.validation.Contains;
import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PersonDto {
    private String name;
    private String surname;
    private Integer height;
    private Integer weight;
    private String secret;
    private EPersonStatus personStatus;
    private AddressDto address;
}
