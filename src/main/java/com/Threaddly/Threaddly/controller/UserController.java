package com.Threaddly.Threaddly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Threaddly.Threaddly.model.UserModel;
import com.Threaddly.Threaddly.service.UserService;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("users")
    public List<UserModel> getAllUser() {
        return userService.getAllUsers();
    }

    @PostMapping("users")
    public boolean createUser(@RequestBody UserModel user) {
        return userService.createUser(user);
    }

    @PutMapping("users/{id}")
    public boolean putMethodName(@PathVariable Long id, @RequestBody UserModel user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("users/{id}")
    public boolean deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }

}
