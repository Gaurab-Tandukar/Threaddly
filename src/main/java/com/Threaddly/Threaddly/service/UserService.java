package com.Threaddly.Threaddly.service;

import java.util.List;

import com.Threaddly.Threaddly.model.request.UserModel;

public interface UserService {

    public boolean createUser(UserModel user);
    public boolean updateUser(Long id, UserModel user);
    public boolean deleteUser(Long id);
    public List<UserModel> getAllUsers();
}
