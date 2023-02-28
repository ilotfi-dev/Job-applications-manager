package com.example.workproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name="person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long person_id;
    private String person_name;
    private String person_mail;
    private Date person_date_of_birth;
    private Timestamp person_created_at;
    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<PersonSkills> personSkills;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return person_id != null && Objects.equals(person_id, person.person_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
