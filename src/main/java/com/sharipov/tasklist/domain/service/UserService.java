package com.sharipov.tasklist.domain.service;

import com.sharipov.tasklist.domain.entity.user.User;


public interface UserService {
    User getById(Long id);
    User getByUsername(String username);
    User update(User user);
    User create(User user);
    void delete(Long id);
}
