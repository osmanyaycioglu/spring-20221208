package com.training.spring.di.services.models;

import com.training.spring.di.data.jpa.EncryptConverter;
import com.training.spring.di.encryption.JasyptSec;
import com.training.spring.di.rest.validation.Contains;
import lombok.*;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@SequenceGenerator(name = "person_sequence", sequenceName = "person_seq", allocationSize = 1)
@Table(name = "person", indexes = {@Index(name = "person_name_surname_index", columnList = "surname,name")})
public class PersonDto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_sequence")
    private Long          personId;

    @Size(min = 2, max = 30)
    private String        name;
    private String        surname;
    @NotNull
    private Integer       height;
    private Integer       weight;
    @Column(name = "note", nullable = false, length = 200)
    @Convert(converter = EncryptConverter.class)
    private String        secret;
    @Enumerated(EnumType.STRING)
    private EPersonStatus personStatus = EPersonStatus.SUSPENDED;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "person")
    private AddressDto    address;
    private String        loader;
    private LocalDateTime updateDate;
    private LocalDateTime createDate = LocalDateTime.now();
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "person")
    private Set<PhoneDto> phones;

    @Version
    private Long personVersion;

    @PrePersist
    @PreUpdate
    //@PreRemove
    public void before() {
        updateDate = LocalDateTime.now();
        loader = JasyptSec.defaultEnc.encrypt("" + hashCode());
    }

    @PostPersist
    @PostUpdate
    @PostRemove
    @PostLoad
    public void after() {

    }

    @Override
    public boolean equals(Object oParam) {
        if (this == oParam) return true;
        if (oParam == null || getClass() != oParam.getClass()) return false;
        PersonDto personDto = (PersonDto) oParam;
        return name.equals(personDto.name)
               && surname.equals(personDto.surname)
               && Objects.equals(height,
                                 personDto.height)
               && Objects.equals(weight,
                                 personDto.weight)
               && secret.equals(personDto.secret)
               && personStatus == personDto.personStatus
               && Objects.equals(address,
                                 personDto.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,
                            surname,
                            height,
                            weight,
                            secret,
                            personStatus,
                            updateDate);
    }
}
