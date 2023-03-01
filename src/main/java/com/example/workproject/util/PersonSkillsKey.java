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
    private Long personId;
    @Column(name="skill_id")
    private Long skillId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonSkillsKey that = (PersonSkillsKey) o;
        return personId.equals(that.personId) && skillId.equals(that.skillId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, skillId);
    }
}
