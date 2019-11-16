package com.gradle.demo.service.impl;

import com.gradle.demo.dao.UserDao;
import com.gradle.demo.domain.User;
import com.gradle.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user) > 0;
    }
}
