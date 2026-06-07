package com.Threaddly.Threaddly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Threaddly.Threaddly.model.response.UserResponse;
import com.Threaddly.Threaddly.service.UserService;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<UserResponse> getAllUser() {
        return userService.getAllUsers();
    }

}
