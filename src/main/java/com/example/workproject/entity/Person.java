package com.example.workproject.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.*;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;
    @Column(name = "person_name")
    private String personName;
    @Column(name = "person_mail")
    private String personMail;

    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "person_date_of_birth")
    private Date personDateOfBirth;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "person_created_at")
    private Date personCreatedAt;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<PersonSkills> personSkills = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return personId != null && Objects.equals(personId, person.personId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
