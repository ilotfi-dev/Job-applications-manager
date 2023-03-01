package com.example.workproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "skill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    private Long skillId;
    @Column(name = "skill_name")
    private String skillName;
    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PersonSkills> personSkills = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Skill skill = (Skill) o;
        return skillId != null && Objects.equals(skillId, skill.skillId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
