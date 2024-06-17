package com.chatapp.service;

import com.chatapp.entity.User;
import java.util.List;

public interface UserService {
    User findByUsername(String username);
    User saveUser(User user);
    List<User> getAllUsers(); // Define a method to fetch all users
}
