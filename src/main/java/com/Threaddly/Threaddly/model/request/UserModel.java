package com.Threaddly.Threaddly.model.request;

import lombok.Data;

@Data
public class UserModel {
    
    private Long id;
    private String name;
    private String email;
    private String password;
}
