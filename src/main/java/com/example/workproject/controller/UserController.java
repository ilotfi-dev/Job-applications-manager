package com.example.workproject.controller;

import com.example.workproject.entity.User;
import com.example.workproject.entity.UserSkill;
import com.example.workproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/home")
    public List<User> users(){
        return userService.showUsers();
    }

    @GetMapping("/{id}")
    public List<UserSkill> userDetail(@PathVariable Long id){
        return userService.showUserDetail(id);
    }

}
