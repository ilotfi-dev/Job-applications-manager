package com.example.workproject.service;

import com.example.workproject.entity.User;
import com.example.workproject.entity.UserSkill;
import com.example.workproject.repository.UserRepository;
import com.example.workproject.repository.UserSkillRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserSkillRepository userSkillRepository;

    public UserService(UserRepository userRepository, UserSkillRepository userSkillRepository) {
        this.userRepository = userRepository;
        this.userSkillRepository = userSkillRepository;
    }

    public List<UserSkill> showUserDetail(Long id){
        User user = userRepository.findById(id).orElse(null);
        return userSkillRepository.findAllByUser(user);
    }
    public List<User> showUsers(){
        return userRepository.findAll();
    }
}
