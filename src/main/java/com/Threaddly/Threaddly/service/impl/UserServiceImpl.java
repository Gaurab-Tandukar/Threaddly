package com.Threaddly.Threaddly.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Threaddly.Threaddly.model.response.UserResponse;
import com.Threaddly.Threaddly.repository.UserRepository;
import com.Threaddly.Threaddly.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    // List<UserModel> users = new ArrayList<>();

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userEntity -> {
            UserResponse userResponse = new UserResponse();
            BeanUtils.copyProperties(userEntity, userResponse);
            return userResponse;
        }).toList();
    }

}
