package com.training.spring.di.services.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "phone")
public class PhoneDto {
    @Id
    @GeneratedValue
    private Long phoneId;
    private String name;
    private String number;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id",nullable = false)
    private PersonDto person;
}
