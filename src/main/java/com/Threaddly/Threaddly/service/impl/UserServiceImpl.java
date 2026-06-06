package com.Threaddly.Threaddly.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Threaddly.Threaddly.entity.UserEntity;
import com.Threaddly.Threaddly.model.request.UserModel;
import com.Threaddly.Threaddly.repository.UserRepository;
import com.Threaddly.Threaddly.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    // List<UserModel> users = new ArrayList<>();


    @Override
    public boolean createUser(UserModel user) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return true;
    }

    @Override
    public boolean updateUser(Long id, UserModel user) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean deleteUser(Long id) {
        userRepository.deleteById(id);
        return true;
    }

    @Override
    public List<UserModel> getAllUsers() {
        return userRepository.findAll().stream().map(userEntity -> {
            UserModel userModel = new UserModel();
            BeanUtils.copyProperties(userEntity, userModel);
            return userModel;
        }).toList();
    }

}
