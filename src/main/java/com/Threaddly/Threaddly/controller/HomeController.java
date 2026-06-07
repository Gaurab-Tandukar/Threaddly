package com.Threaddly.Threaddly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {

    @GetMapping("/home")
    public String getMethodName() {
        return "Welcome to Threaddly API!";
    }
    
}
