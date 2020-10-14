package com.nm.travel.service;

import com.nm.travel.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
