package com.Threaddly.Threaddly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Threaddly.Threaddly.entity.UserEntity;
import com.Threaddly.Threaddly.model.request.RegisterRequest;
import com.Threaddly.Threaddly.repository.UserRepository;
import com.Threaddly.Threaddly.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @Override
    public boolean registerUser(RegisterRequest registerRequest) {
        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(registerRequest.getUsername());
        userEntity.setEmail(registerRequest.getEmail());
        userEntity.setPasswordHash(passwordEncoder.encode(registerRequest.getPassword()));
        
        if (userRepository.existsByEmail(registerRequest.getEmail()) ||
            userRepository.existsByUsername(registerRequest.getUsername())) {
            return false;
        }
        
        userRepository.save(userEntity);

        return true;
    }

}
