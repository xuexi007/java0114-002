package com.offcn.service;

import com.offcn.po.User;

import java.util.List;

public interface UserService {
    public String createUser(User user);
    public List<User> findAll();
    public User findOneUser(Long id);
    public String updateUserById(Long id, User user);
    public String deleteById(Long id);
}
