package com.upit.service;

import com.upit.model.User;

public interface UserService {
    public User findUserById(Long userId) throws Exception;
}
