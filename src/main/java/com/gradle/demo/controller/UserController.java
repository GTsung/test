package com.gradle.demo.controller;

import com.gradle.demo.common.PrintLogAnn;
import com.gradle.demo.domain.User;
import com.gradle.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "user/getList")
    @PrintLogAnn(printReturnLog = true)
    public List<User> getUserList(){
        return userService.getUserList();
    }

    @PostMapping(value = "user/add")
    public boolean addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

}
