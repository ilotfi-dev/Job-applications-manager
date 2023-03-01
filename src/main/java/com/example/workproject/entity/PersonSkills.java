package com.example.workproject.entity;

import com.example.workproject.util.PersonSkillsKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "person_skill")
public class PersonSkills {
    @EmbeddedId
    private PersonSkillsKey id;
    @ManyToOne
    @MapsId("personId")
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;
    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private int rank;

    private String note;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PersonSkills that = (PersonSkills) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
