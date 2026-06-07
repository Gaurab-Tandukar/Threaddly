package com.Threaddly.Threaddly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Threaddly.Threaddly.model.request.RegisterRequest;
import com.Threaddly.Threaddly.service.RegisterService;

@RestController
public class RegisterController {
    
    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public boolean registerUser(@RequestBody RegisterRequest registerRequest) {
        return registerService.registerUser(registerRequest);
    }

}
