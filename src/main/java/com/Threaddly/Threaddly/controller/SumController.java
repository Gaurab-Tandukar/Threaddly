package com.Threaddly.Threaddly.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SumController {

    @PostMapping("sum")
    public String sum(@RequestParam int num1, @RequestParam int num2) {
        int sum = num1 + num2;
        String result = String.format("The sum of %d and %d is %d", num1, num2, sum);
        return result;
    }
}
