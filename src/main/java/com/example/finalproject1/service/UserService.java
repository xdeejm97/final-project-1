package com.example.finalproject1.service;

import com.example.finalproject1.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
