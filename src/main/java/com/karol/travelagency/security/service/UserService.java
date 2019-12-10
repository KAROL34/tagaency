package com.karol.travelagency.security.service;

import com.karol.travelagency.dto.UserForm;
import com.karol.travelagency.security.model.User;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    void save(UserForm user);

    User findByUserName(String userName);

    List<User> getAllUsers();

}
