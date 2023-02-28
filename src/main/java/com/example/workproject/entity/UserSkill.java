package com.example.workproject.entity;

import com.example.workproject.util.UserSkillKey;
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
@Table(name = "test_skill")
public class UserSkill {
    @EmbeddedId
    @JsonIgnore
    private UserSkillKey id;
    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @MapsId("skill_id")
    @JoinColumn(name = "skill_id")
    private Skill skill;

    private int rating;

    private String note;



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UserSkill userSkill = (UserSkill) o;
        return id != null && Objects.equals(id, userSkill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
