package com.training.spring.di.services.models;

import com.training.spring.di.rest.validation.Contains;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@SequenceGenerator(name = "person_sequence", sequenceName = "person_seq", allocationSize = 1)
@Table(name = "person",indexes = {@Index(name = "person_name_surname_index",columnList = "surname,name")})
public class PersonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "person_sequence")
    private Long          personId;
    @Size(min = 2,max = 30)
    private String        name;
    private String        surname;
    @NotNull
    private Integer       height;
    private Integer       weight;
    @Column(name = "note",nullable = false,length = 200)
    private String        secret;
    private EPersonStatus personStatus;
    @Transient
    private AddressDto    address;
}
