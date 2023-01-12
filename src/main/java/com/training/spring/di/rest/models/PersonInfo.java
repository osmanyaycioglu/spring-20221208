package com.training.spring.di.rest.models;

import com.training.spring.di.rest.validation.Contains;
import lombok.*;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class PersonInfo {
    private String name;
    private String surname;
    private Integer height;
    private Integer weight;
}
