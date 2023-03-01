package com.example.workproject.repository;

import com.example.workproject.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
    Optional<Skill> findSkillBySkillId(Long id);
}
