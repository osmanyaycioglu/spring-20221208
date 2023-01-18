package com.training.spring.common.design;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class CompanyUser {
    @Id
    @GeneratedValue
    private Long userId;
    private String username;
    private String password;
    private ERole role;
    @OneToOne(fetch = FetchType.EAGER)
    private Company company;
}
