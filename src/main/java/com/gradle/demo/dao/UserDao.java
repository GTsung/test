package com.gradle.demo.dao;

import com.gradle.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select userId,name,age,email,address from user")
    List<User> getUserList();
}
