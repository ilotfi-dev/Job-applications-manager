package com.example.workproject.util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PersonSkillsKey implements Serializable {
    @Column(name = "person_id")
    private Long person_id;
    @Column(name="skill_id")
    private Long skill_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonSkillsKey that = (PersonSkillsKey) o;
        return person_id.equals(that.person_id) && skill_id.equals(that.skill_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person_id, skill_id);
    }
}
