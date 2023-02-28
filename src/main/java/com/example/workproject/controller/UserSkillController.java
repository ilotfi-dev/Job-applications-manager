package com.example.workproject.controller;

import com.example.workproject.entity.UserSkill;
import com.example.workproject.service.UserSkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserSkillController {
    private final UserSkillService userSkillService;

    public UserSkillController(UserSkillService userSkillService) {
        this.userSkillService = userSkillService;
    }
    @GetMapping("/home")
    public List<UserSkill> userSkillList(){
        return userSkillService.showUserSkills();
    }
}
