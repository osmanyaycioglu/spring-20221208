package com.training.spring.di.services.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "address_sequence", sequenceName = "address_seq", allocationSize = 1)
@Table(name = "address")
public class AddressDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long addId;
    private String city;
    private String street;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private PersonDto person;


}
