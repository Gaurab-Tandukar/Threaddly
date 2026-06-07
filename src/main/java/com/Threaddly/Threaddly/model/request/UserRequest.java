package com.Threaddly.Threaddly.model.request;

import lombok.Data;

@Data
public class UserRequest {
    
    private String username;
    private String email;
    private String password;
}
