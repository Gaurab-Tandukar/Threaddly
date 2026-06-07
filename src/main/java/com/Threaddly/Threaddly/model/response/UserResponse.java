package com.Threaddly.Threaddly.model.response;

import java.time.LocalDateTime;

import com.Threaddly.Threaddly.entity.UserEntity.Role;
import com.Threaddly.Threaddly.entity.UserEntity.Status;

import lombok.Data;

@Data
public class UserResponse {
    private String id;
    private String username;
    private String email;
    private Status status;           
    private Role role;                
    private LocalDateTime createdAt;  
}