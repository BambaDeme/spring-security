package com.deme.ahmadou.security.service;

import com.deme.ahmadou.security.models.Role;
import com.deme.ahmadou.security.models.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String userName);
    List<User> getUsers();
}
