package com.iqmsoft.boot.mybatis.repository;

import java.util.List;

import com.iqmsoft.boot.mybatis.model.entity.User;


public interface UserRepository {

    User selectUserById(Long id);

    User selectUserByUsername(String username);

    List<User> selectAllUsers();

    Integer insertUser(User user);

    Integer updateUserOnPasswordById(User user);

    Integer deleteUserById(Long id);

}
