package com.example.workproject.util;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Embeddable
public class UserSkillKey implements Serializable {
    @Column( name = "user_id")
    private Long user_id;
    @Column(name="skill_id")
    private Long skill_id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSkillKey that = (UserSkillKey) o;
        return Objects.equals(user_id, that.user_id) && Objects.equals(skill_id, that.skill_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, skill_id);
    }
}
