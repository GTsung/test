package com.gradle.demo.service;

import com.gradle.demo.domain.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    boolean addUser(User user);
}
