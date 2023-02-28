package com.example.workproject.controller;

import com.example.workproject.entity.Skill;
import com.example.workproject.service.SkillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/home")
    public List<Skill> skills(){
        return skillService.showSkills();
    }
}
