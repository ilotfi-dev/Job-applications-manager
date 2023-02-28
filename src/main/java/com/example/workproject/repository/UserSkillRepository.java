package com.example.workproject.repository;

import com.example.workproject.entity.User;
import com.example.workproject.entity.UserSkill;
import com.example.workproject.util.UserSkillKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserSkillRepository extends JpaRepository<UserSkill, UserSkillKey> {

    List<UserSkill> findAllByUser(User user);
}
