package com.training.spring.di.rest.models;

import com.training.spring.di.rest.validation.Contains;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonInfo {
    private String name;
    private String surname;
    private Integer height;
    private Integer weight;
}
