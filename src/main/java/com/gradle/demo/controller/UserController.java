package com.gradle.demo.controller;

import com.gradle.demo.domain.User;
import com.gradle.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "user/getList")
    public List<User> getUserList(){
        return userService.getUserList();
    }


}
