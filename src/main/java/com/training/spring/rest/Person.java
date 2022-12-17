package com.training.spring.rest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Person {
    private String name;
    private String surname;
    private Integer height;
    private Integer weight;
    private Integer xyz; // optional

}
