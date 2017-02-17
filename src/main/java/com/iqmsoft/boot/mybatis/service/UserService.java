package com.iqmsoft.boot.mybatis.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.iqmsoft.boot.mybatis.model.entity.User;

import java.util.Optional;


public interface UserService extends UserDetailsService {

    Optional<User> getUserById(Long id);

    boolean saveUser(User user);

    boolean modifyUserOnPasswordById(User user);

    boolean deleteUserById(Long id);

}
