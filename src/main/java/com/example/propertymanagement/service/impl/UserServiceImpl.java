package com.example.propertymanagement.service.impl;

import com.example.propertymanagement.converter.UserConverter;
import com.example.propertymanagement.entity.UserEntity;
import com.example.propertymanagement.model.UserDto;
import com.example.propertymanagement.repository.UserRepository;
import com.example.propertymanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;

    @Override
    public UserDto register(UserDto userDto) {
        UserEntity userEntity = userConverter.convertDtoToEntity(userDto);
        userEntity = userRepository.save(userEntity);
        userDto = userConverter.convertEntityToDto(userEntity);
        return userDto;
    }

    @Override
    public UserDto login(String email, String password) {
        UserDto userDto = null;
        Optional<UserEntity> userEntity = userRepository.findByOwnerEmailAndPassword(email,password);
        if (userEntity.isPresent()){
            userDto = userConverter.convertEntityToDto(userEntity.get());
        }
        return userDto;
    }
}
