package com.training.spring.di.rest;

import com.training.spring.di.rest.validation.Contains;
import com.training.spring.di.rest.validation.ContainsObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;

@Getter
@Setter
@ToString
@ContainsObject({"qwerty","ttt","aaa","bbb"})
public class Person {
    @NotNull(message = "name null olamaz")
    @NotEmpty
    @NotBlank
    @Size(min = 2,max = 18)
    @Contains({"123","1234","abc","xyz"})
    private String name;
    @NotNull(message = "surname null olamaz")
    @NotEmpty
    @NotBlank
    @Size(min = 3,max = 25)
    @Contains({"123","1234","abc","xyz"})
    private String surname;
    @NotNull
    @Max(300)
    @Min(60)
    private Integer height;
    @NotNull
    @Max(500)
    @Min(value = 10,message = "ağırlık 10 dan küçük olamaz")
    private Integer weight;
    @NotNull
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$") // Minimum eight characters, at least one letter and one number
    @Contains({"123","1234","abc","xyz","test","deneme"})
    private String password;
    private Integer xyz; // optional

}
