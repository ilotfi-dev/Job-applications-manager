package com.example.workproject.service;

import com.example.workproject.entity.UserSkill;
import com.example.workproject.repository.UserSkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSkillService {
    private final UserSkillRepository userSkillRepository;

    public UserSkillService(UserSkillRepository userSkillRepository) {
        this.userSkillRepository = userSkillRepository;
    }

    public List<UserSkill> showUserSkills(){
        return userSkillRepository.findAll();
    }
}
