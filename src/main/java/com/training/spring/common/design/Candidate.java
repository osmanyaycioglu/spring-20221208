package com.training.spring.common.design;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
//@NamedEntityGraphs({
//        @NamedEntityGraph(name = "Candidate.basic", attributeNodes = {@NamedAttributeNode("user")})
//})
@Entity
public class Candidate {
    @Id
    @GeneratedValue
    private Long             candidateId;
    private String           candidateUid;
    private String           firstName;
    private String           middleName;
    private String           lastName;
    private String           identityNumber;
    private LocalDate        birthdate;
    private ECandidateStatus candidateStatus;
    @CreationTimestamp
    private LocalDateTime    creationDate;
    @UpdateTimestamp
    private LocalDateTime    updateDate;


    private Long companyId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private CompanyUser user;

    @PrePersist
    public void beforeInsert() {
        candidateUid = UUID.randomUUID()
                           .toString();
    }

}
